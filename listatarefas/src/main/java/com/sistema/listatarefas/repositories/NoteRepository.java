package com.sistema.listatarefas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.listatarefas.model.Note;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Long> {
	
	@Query(value = "select * from notes where finished = false order by priority = 'NORMAL', date_task", nativeQuery = true)
	Page<Note> findNotesPagePriority(Pageable pageable);

}
