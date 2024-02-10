package com.sistema.listatarefas.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.listatarefas.model.Note;
import com.sistema.listatarefas.services.NoteService;

import jakarta.validation.Valid;

@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("notes", noteService.listNote(PageRequest.of(0, 5)));
		return modelAndView;
	}

	@GetMapping("/notespag")
	public ModelAndView loadPageNotes(@PageableDefault(size = 5) Pageable pageable, ModelAndView model) {

		Page<Note> pageNote = noteService.listNotePage(pageable);
		model.addObject("notes", pageNote);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = "register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("noteobj", new Note());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "**/savenotes")
	public ModelAndView saveNotes(@Valid Note note, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("/register");
			modelAndView.addObject("noteobj", note);

			List<String> msg = new ArrayList<String>();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				msg.add(objectError.getDefaultMessage());
			}

			modelAndView.addObject("msg", msg);
			return modelAndView;
		}

		ModelAndView modelAndView = new ModelAndView("/register");
		modelAndView.addObject("noteobj", note);

		String msgok = new String("Registrado com sucesso!");

		Date now = new Date();
		note.setDate_task(now);
		note.setFinished(false);

		noteService.save(note);
		modelAndView.addObject("msgok", msgok);
		modelAndView.addObject("noteobj", new Note());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "**/editnote/{id}")
	public ModelAndView editNote(@PathVariable("id") Long id) {
		Optional<Note> note = noteService.findNoteById(id);
		ModelAndView modelAndView = new ModelAndView("/register");
		modelAndView.addObject("noteobj", note.get());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "**/notes/{id}")
	public ModelAndView getNoteDetail(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("detailnote");
		Note note = noteService.findNoteById(id).get();
		modelAndView.addObject("notes", note);
		return modelAndView;
	}

}
