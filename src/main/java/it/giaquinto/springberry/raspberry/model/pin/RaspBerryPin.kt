package it.giaquinto.springberry.raspberry.model.pin

import it.giaquinto.springberry.raspberry.model.pin.modulation.ModulationTechnique
import it.giaquinto.springberry.raspberry.model.pin.specification.PinMode
import it.giaquinto.springberry.raspberry.model.pin.specification.PinVolt

data class RaspBerryPin(
    override val physical: Int,
    override val bcmCode: Int?,
    override val wiringPiCode: Int?,
    override val name: String,
    override val mode: PinMode,
    override val volt: PinVolt,
    override val modulation: ModulationTechnique
) : Pin
