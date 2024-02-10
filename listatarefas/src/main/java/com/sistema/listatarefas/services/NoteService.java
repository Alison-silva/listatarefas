package com.sistema.listatarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sistema.listatarefas.model.Note;
import com.sistema.listatarefas.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	public Note save(Note note) {
		return noteRepository.save(note);
	}

	public Page<Note> listNote(PageRequest pageRequest) {
		return noteRepository.findNotesPagePriority(PageRequest.of(0, 5));
	}

	public Page<Note> listNotePage(Pageable pageable) {
		return noteRepository.findNotesPagePriority(pageable);
	}

	public void delete(Long id) {
		noteRepository.deleteById(id);
	}

	public Optional<Note> findNoteById(Long id) {
		return noteRepository.findById(id);
	}
}
