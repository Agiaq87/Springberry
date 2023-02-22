package it.giaquinto.springberry.raspberry.model.protocol.synchronous

import it.giaquinto.springberry.raspberry.ProtocolName
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.protocol.Protocol

class I2CProtocol(val data: RaspBerryPin, val clock: RaspBerryPin) : Protocol.Synchronous {
    override val fullName: ProtocolName = "Inter-Integrated Circuit"

}