package it.giaquinto.springberry.spring.controller.utils

import it.giaquinto.springberry.spring.annotation.SpringBerryRestController
import it.giaquinto.springberry.spring.Identifier
import it.giaquinto.springberry.spring.RestRadix
import it.giaquinto.springberry.spring.controller.SpringBerryController
import it.giaquinto.springberry.spring.entity.Note
import it.giaquinto.springberry.spring.model.api.ApiResult
import it.giaquinto.springberry.spring.model.http.HttpRequest
import it.giaquinto.springberry.spring.model.http.HttpStatusCode
import it.giaquinto.springberry.spring.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Template controller
 */
@SpringBerryRestController
class NoteController : SpringBerryController<List<Note?>?>() {

    @Autowired
    lateinit var noteRepository: NoteRepository
    override val identifier: Identifier
        get() = this.javaClass.packageName
    override val uniqueRestRadix: RestRadix
        get() = NoteController.uniqueRestRadix

    @GetMapping("${NoteController.uniqueRestRadix}/$radixControllerAcceptedRequest")
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
        propagateApiResult(ApiResult.Success(noteRepository.findAll()))

    @GetMapping("${NoteController.uniqueRestRadix}/id/{id}")
    fun findById(@PathVariable id: Long?): ApiResult<Note?> =
        propagateApiResult(
            if (id != null) {
                with(noteRepository.findById(id)) {
                    if (isEmpty)
                        ApiResult.Error("Not found", HttpStatusCode.NO_CONTENT)
                    else
                        ApiResult.Success(get())
                }
            } else {
                ApiResult.Error("Needed an ID", HttpStatusCode.NO_CONTENT)
            }
        )

    @GetMapping("${NoteController.uniqueRestRadix}/name/{name}")
    fun findByName(@PathVariable name: String?): ApiResult<Note?> =
        propagateApiResult(
            if (name != null) {
                with(noteRepository.findByName(name)) {
                    if (isEmpty) {
                        ApiResult.Error("Not found", HttpStatusCode.NO_CONTENT)
                    } else {
                        ApiResult.Success(get())
                    }
                }
            } else {
                ApiResult.Error("Needed an ID", HttpStatusCode.NO_CONTENT)
            }
        )

    @PostMapping(NoteController.uniqueRestRadix)
    fun create(@RequestBody note: Note?): ApiResult<Note?> =
        propagateApiResult(
            note?.let {
                ApiResult.Success(
                    noteRepository.save(it)
                )
            } ?: run {
                ApiResult.Error("Incorrect value, expected JSON Note")
            }
        )


    companion object {
        const val uniqueRestRadix = "note"
    }
}