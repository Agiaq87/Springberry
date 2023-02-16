package it.giaquinto.springberry.model.user.implementation

import it.giaquinto.springberry.model.security.SecurityLevel
import java.time.LocalDateTime

class PowerUser(
    name: String?,
    surname: String?,
    created: LocalDateTime?
) : BaseUser(name, surname, created) {
    override fun levelOf(): SecurityLevel? {
        return SecurityLevel.POWER
    }

    override fun equals(obj: Any?): Boolean {
        return super.equals(obj)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}