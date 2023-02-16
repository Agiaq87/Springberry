package it.giaquinto.springberry.model.user.implementation

import it.giaquinto.springberry.model.security.SecurityLevel
import java.time.LocalDateTime

class AdminUser(
    name: String?,
    surname: String?,
    created: LocalDateTime?
) : BaseUser(name, surname, created) {
    override fun levelOf(): SecurityLevel? {
        return SecurityLevel.ADMIN
    }
}