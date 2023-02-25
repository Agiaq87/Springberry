package it.giaquinto.springberry.raspberry.model.pin

import it.giaquinto.springberry.raspberry.BcmAddress
import it.giaquinto.springberry.raspberry.PinAddress
import it.giaquinto.springberry.raspberry.PinName
import it.giaquinto.springberry.raspberry.WiringPiAddress
import it.giaquinto.springberry.raspberry.model.pin.modulation.ModulationTechnique
import it.giaquinto.springberry.raspberry.model.pin.specification.PinMode
import it.giaquinto.springberry.raspberry.model.pin.specification.PinVolt

class RaspBerryPin(
    override val physical: PinAddress,
    override val bcmAddress: BcmAddress?,
    override val wiringPiCode: WiringPiAddress?,
    override val name: PinName,
    override var mode: PinMode,
    override val volt: PinVolt,
    override val modulation: ModulationTechnique
) : Pin
