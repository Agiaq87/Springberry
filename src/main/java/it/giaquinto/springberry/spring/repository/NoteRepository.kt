package it.giaquinto.springberry.spring.repository

import it.giaquinto.springberry.spring.entity.Note
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NoteRepository: JpaRepository<Note, Long> {

    fun findByName(name: String): Optional<Note>
}