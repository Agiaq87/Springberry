package it.giaquinto.springberry.model.user.service

import it.giaquinto.springberry.model.security.SecurityLevel
import it.giaquinto.springberry.model.user.UserFactory
import it.giaquinto.springberry.model.user.implementation.BaseUser
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
interface UserDaoService {
    fun searchName(name: String?): BaseUser?
    fun searchSurname(surname: String?): BaseUser?
    fun searchCreated(localDateTime: LocalDateTime?): List<BaseUser?>?
    fun retrieveAll(): List<BaseUser?>?
    fun retrieveAll(level: SecurityLevel?): List<BaseUser?>?
    fun makeNewUser(user: BaseUser, level: SecurityLevel?): BaseUser? {
        return UserFactory.fromBaseUser(user, level)
    }
}