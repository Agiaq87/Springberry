package it.giaquinto.springberry.spring.model

import it.giaquinto.springberry.spring.model.logger.LogMessage

interface SpringBerryModel {
    fun toLog(): LogMessage
}