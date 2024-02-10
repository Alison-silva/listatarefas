package com.sistema.listatarefas.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistema.listatarefas.model.enuns.Priority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity(name = "notes")
@Table(name = "notes")
@SequenceGenerator(sequenceName = "notes_seq", name = "notes_seq", allocationSize = 1, initialValue = 1)
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_seq")
	private Long id;

	@NotEmpty(message = "Título não pode ser vazio!")
	@NotNull(message = "Título não pode ser nulo!")
	private String title;

	@NotEmpty(message = "Texto não pode ser vazio!")
	@NotNull(message = "Texto não pode ser nulo!")
	@Column(columnDefinition = "text")
	private String notes;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date_task;

	@NotNull(message = "Prioridade não pode ser nula!")
	@Enumerated(EnumType.STRING)
	private Priority priority;

	private boolean finished;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDate_task() {
		return date_task;
	}

	public void setDate_task(Date date_task) {
		this.date_task = date_task;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
