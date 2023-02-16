package it.giaquinto.springberry.model.builder.connector.exception

class AsyncTimeNegativeException : Exception {
    constructor()
    constructor(message: String?) : super(message)

    override val message: String
        get() = "Async timeout can not be negative"
}