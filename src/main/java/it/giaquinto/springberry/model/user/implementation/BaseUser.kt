package it.giaquinto.springberry.model.user.implementation

import it.giaquinto.springberry.model.user.User
import java.time.LocalDateTime
import java.util.*

abstract class BaseUser(
    val name: String?,
    val surname: String?,
    val created: LocalDateTime?
) : User {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        return if (o !is BaseUser) false else name == o.name && surname == o.surname && created == o.created
    }

    override fun hashCode(): Int {
        return Objects.hash(name, surname, created)
    }
}