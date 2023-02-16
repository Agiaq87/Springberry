package it.giaquinto.springberry.model.specific.memory

import it.giaquinto.springberry.model.security.SecurityLevel
import java.lang.management.ManagementFactory

class MemoryProperties(level: SecurityLevel) {
    val heap: ReadableMemoryProperties
    val nonHeap: ReadableMemoryProperties

    init {
        val memory = ManagementFactory.getMemoryMXBean()
        if (level == SecurityLevel.ADMIN || level == SecurityLevel.POWER) {
            memory.isVerbose = true
        }
        heap = ReadableMemoryProperties(memory.heapMemoryUsage)
        nonHeap = ReadableMemoryProperties(memory.nonHeapMemoryUsage)
    }

    override fun toString(): String {
        return "MemoryProperties{heap=$heap, nonHeap=$nonHeap}"
    }
}