package it.giaquinto.springberry.raspberry.model.pin.specification

import it.giaquinto.springberry.raspberry.model.pin.modulation.ModulationTechnique

sealed class PinModulation(val technique: ModulationTechnique) {
    data class AnalogModulation(val _technique: ModulationTechnique.AnalogTechnique) : PinModulation(
        technique = _technique
    )

    data class DigitalModulation(val _technique: ModulationTechnique.DigitalTechnique) : PinModulation(
        technique = _technique
    )
}
