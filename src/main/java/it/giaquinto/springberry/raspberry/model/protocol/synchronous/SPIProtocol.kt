package it.giaquinto.springberry.raspberry.model.protocol.synchronous

import it.giaquinto.springberry.raspberry.ProtocolName
import it.giaquinto.springberry.raspberry.model.protocol.Protocol

class SPIProtocol : Protocol.Synchronous {
    override val fullName: ProtocolName = "Serial Peripheral Interface"
}