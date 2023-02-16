package it.giaquinto.springberry.model.note

import it.giaquinto.springberry.model.user.User
import java.time.LocalDateTime


data class Note(val name: String, val description: String, val dateTime: LocalDateTime, val user: User)