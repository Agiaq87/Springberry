package it.giaquinto.springberry.model.user

import it.giaquinto.springberry.model.security.SecurityLevel
import it.giaquinto.springberry.model.user.implementation.*

object UserFactory {
    fun fromBaseUser(baseUser: BaseUser, level: SecurityLevel?): BaseUser {
        return when (level) {
            SecurityLevel.NONE -> null
            SecurityLevel.GUEST -> GuestUser(baseUser.name, baseUser.surname, baseUser.created)
            SecurityLevel.NORMAL -> NormalUser(baseUser.name, baseUser.surname, baseUser.created)
            SecurityLevel.POWER -> PowerUser(baseUser.name, baseUser.surname, baseUser.created)
            SecurityLevel.ADMIN -> AdminUser(baseUser.name, baseUser.surname, baseUser.created)
        }
    }
}