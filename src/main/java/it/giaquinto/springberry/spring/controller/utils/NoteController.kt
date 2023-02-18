package it.giaquinto.springberry.spring.controller.utils

import it.giaquinto.springberry.spring.model.http.HttpRequest
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.controller.SpringBerryController
import it.giaquinto.springberry.spring.entity.Note
import it.giaquinto.springberry.spring.model.http.ApiResult
import it.giaquinto.springberry.spring.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 * Template controller
 */
@RestController
class NoteController : SpringBerryController<List<Note?>?> {

    @Autowired
    lateinit var noteRepository: NoteRepository
    override val identifier: Identifier
        get() = this.javaClass.packageName
    override val uniqueRestRadix: RestRadix
        get() = NoteController.uniqueRestRadix

    @GetMapping("${NoteController.uniqueRestRadix}/${SpringBerryController.radixControllerAcceptedRequest}")
    override fun controllerAcceptedMethod(): ApiResult<Array<HttpRequest?>> =
        ApiResult.Success(
            arrayOf(
                HttpRequest.GET,
                HttpRequest.POST,
                HttpRequest.PUT,
                HttpRequest.PATCH,
                HttpRequest.DELETE
            )
        )

    @GetMapping(NoteController.uniqueRestRadix)
    override fun defaultResponse(): ApiResult<List<Note?>?> =
        ApiResult.Success(noteRepository.findAll())

    @GetMapping("${NoteController.uniqueRestRadix}/{id}")
    fun findById(@PathVariable id: Long?): ApiResult<Optional<Note>?> =
        ApiResult.Success(
            id?.let { noteRepository.findById(it) } ?: run { null }
        )

    @GetMapping("${NoteController.uniqueRestRadix}/{name}")
    fun findByName(@PathVariable name: String?): ApiResult<Optional<Note>?> =
        ApiResult.Success(
            name?.let { noteRepository.findByName(it) } ?: run { null }
        )

    @PostMapping(NoteController.uniqueRestRadix)
    fun create(@RequestBody note: Note?): ApiResult<Note?> =
        note?.let {
            ApiResult.Success(
                noteRepository.save(it)
            )
        } ?: run {
            ApiResult.Error("Incorrect value, expected JSON Note")
        }



    companion object {
        const val uniqueRestRadix = "note"
    }
}