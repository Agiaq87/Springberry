package it.giaquinto.springberry.model.math

abstract class NumberRepresentation {
    abstract val binary: String
    abstract val octal: String
    abstract val value: String?
    abstract val hex: String
}