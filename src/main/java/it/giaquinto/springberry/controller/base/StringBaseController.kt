package it.giaquinto.springberry.controller.base

import it.giaquinto.springberry.controller.SpringBerryBaseController
import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.model.sorted.implementation.GenericSorted
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StringBaseController : SpringBerryBaseController() {
    override fun ID(): String {
        return StringBaseController::class.java.name
    }

    override fun controllerAcceptedRequest(): Array<HttpRequest> {
        return arrayOf(
            HttpRequest.GET
        )
    }

    /*@GetMapping(path = ["string/length/{string}"])
    fun length(@PathVariable string: String): Int {
        return string.length
    }

    @GetMapping(path = ["string/orderDescending/{string}"])
    fun orderDescending(@PathVariable string: String): String {
        return stringUtils.revertToString(
            GenericSorted<Char?>().sortDescending(
                stringUtils.toList(
                    string.toCharArray()
                )
            )
        )
    }

    @GetMapping(path = ["string/orderGrowing/{string}"])
    fun orderGrowing(@PathVariable string: String): String {
        return stringUtils.revertToString(
            GenericSorted<Char?>().sortGrowing(
                stringUtils.toList(
                    string.toCharArray()
                )
            )
        )
    }

    @GetMapping(path = ["string/palindrome/{string}"])
    fun palindrome(@PathVariable string: String?): Boolean {
        return stringUtils.palindrome(string!!)
    }*/
}