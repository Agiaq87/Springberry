package it.giaquinto.springberry.model.user

import it.giaquinto.springberry.model.security.SecurityLevel

interface User {
    fun levelOf(): SecurityLevel?
}