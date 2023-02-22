package it.giaquinto.springberry.raspberry.model.pin.modulation

sealed interface ModulationTechnique {
    interface AnalogTechnique : ModulationTechnique

    interface DigitalTechnique : ModulationTechnique

    object Generic : ModulationTechnique

}