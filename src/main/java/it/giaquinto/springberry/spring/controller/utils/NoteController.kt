package it.giaquinto.springberry.spring.controller.utils

import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.controller.SpringBerryController
import it.giaquinto.springberry.spring.entity.Note
import it.giaquinto.springberry.spring.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class NoteController: SpringBerryController<List<Note>> {

    @Autowired
    lateinit var  noteRepository: NoteRepository
    override val identifier: Identifier
        get() = this.javaClass.packageName
    override val uniqueRestRadix: RestRadix
        get() = NoteController.uniqueRestRadix

    @GetMapping(NoteController.uniqueRestRadix)
    override fun defaultResponse(): List<Note> =
        noteRepository.findAll()

    @GetMapping("${NoteController.uniqueRestRadix}/id/{id}")
    fun findById(@PathVariable id: Long?): Any? =
        try {
            id?.let {
                noteRepository.findById(it)
            }
        } catch (_: Exception) {
            null
        }


    companion object {
        const val uniqueRestRadix = "note"
    }
}