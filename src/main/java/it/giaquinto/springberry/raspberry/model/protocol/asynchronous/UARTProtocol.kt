package it.giaquinto.springberry.raspberry.model.protocol.asynchronous

import it.giaquinto.springberry.raspberry.ProtocolName
import it.giaquinto.springberry.raspberry.model.protocol.Protocol

class UARTProtocol : Protocol.Asynchronous {
    override val fullName: ProtocolName = "Universal Asynchronous Receiver-Transmitter"
}