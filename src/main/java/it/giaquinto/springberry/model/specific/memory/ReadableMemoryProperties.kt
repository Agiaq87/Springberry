package it.giaquinto.springberry.model.specific.memory

import it.giaquinto.springberry.utils.memory.UnitMemoryConverter
import java.lang.management.MemoryUsage

class ReadableMemoryProperties(
    val source: MemoryUsage
) {
    val initMB: String
    val usedMB: String
    val committedMB: String
    val maxMB: String

    init {
        initMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.init))
        usedMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.used))
        committedMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.committed))
        maxMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(source.max))
    }

    override fun toString(): String {
        return "ReadableMemoryProperties{" +
                "source=" + source +
                ", initMB='" + initMB + '\'' +
                ", usedMB='" + usedMB + '\'' +
                ", committedMB='" + committedMB + '\'' +
                ", maxMB='" + maxMB + '\'' +
                '}'
    }
}