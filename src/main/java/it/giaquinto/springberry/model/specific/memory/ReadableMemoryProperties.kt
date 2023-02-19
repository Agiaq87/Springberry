package it.giaquinto.springberry.model.specific.memory

import it.giaquinto.springberry.spring.utils.memory.UnitMemoryConverter
import java.lang.management.MemoryUsage

data class ReadableMemoryProperties(
    private val source: MemoryUsage
) {
    val initMB: String = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.init))
    val usedMB: String = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.used))
    val committedMB: String = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.committed))
    val maxMB: String = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.max))
}