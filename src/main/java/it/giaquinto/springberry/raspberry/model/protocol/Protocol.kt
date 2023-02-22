package it.giaquinto.springberry.raspberry.model.protocol

import it.giaquinto.springberry.raspberry.ProtocolName

sealed interface Protocol {

    val fullName: ProtocolName

    interface Synchronous : Protocol

    interface Asynchronous : Protocol
}