package it.giaquinto.springberry.model.raspberry.pin

class IncorrectPhysicalPinSpecifiedException(message: String?) : Exception(message) {
    override val message: String
        get() = super.message!!
}