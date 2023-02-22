package it.giaquinto.springberry.raspberry.model.protocol.asynchronous

import it.giaquinto.springberry.raspberry.ProtocolName
import it.giaquinto.springberry.raspberry.model.protocol.Protocol

class PWMProtocol : Protocol.Asynchronous {
    override val fullName: ProtocolName = "Pulse Width Modulation"
}