package it.giaquinto.springberry.spring.repository

import it.giaquinto.springberry.spring.entity.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository: JpaRepository<Note, Long>