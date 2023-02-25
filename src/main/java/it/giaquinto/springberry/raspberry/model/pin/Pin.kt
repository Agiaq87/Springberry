package it.giaquinto.springberry.raspberry.model.pin

import it.giaquinto.springberry.raspberry.BcmAddress
import it.giaquinto.springberry.raspberry.PinAddress
import it.giaquinto.springberry.raspberry.PinName
import it.giaquinto.springberry.raspberry.WiringPiAddress
import it.giaquinto.springberry.raspberry.model.pin.modulation.ModulationTechnique
import it.giaquinto.springberry.raspberry.model.pin.specification.PinMode
import it.giaquinto.springberry.raspberry.model.pin.specification.PinVolt

interface Pin {
    val physical: PinAddress
    val bcmAddress: BcmAddress?
    val wiringPiCode: WiringPiAddress?
    val name: PinName
    var mode: PinMode
    val volt: PinVolt
    val modulation: ModulationTechnique


    fun haveWiringPiCode(): Boolean = wiringPiCode != null

    fun haveBCMCode(): Boolean = bcmAddress != null
}