package it.giaquinto.springberry.raspberry.model.pin

import it.giaquinto.springberry.raspberry.model.pin.modulation.ModulationTechnique
import it.giaquinto.springberry.raspberry.model.pin.specification.PinMode
import it.giaquinto.springberry.raspberry.model.pin.specification.PinVolt

interface Pin {
    val physical: Int
    val bcmCode: Int?
    val wiringPiCode: Int?
    val name: String
    val mode: PinMode
    val volt: PinVolt
    val modulation: ModulationTechnique


    fun haveWiringPiCode(): Boolean = wiringPiCode != null

    fun haveBCMCode(): Boolean = bcmCode != null
}