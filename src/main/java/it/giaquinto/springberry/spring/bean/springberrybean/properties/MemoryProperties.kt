package it.giaquinto.springberry.spring.bean.springberrybean.properties

import java.lang.management.ManagementFactory

class MemoryProperties {
    val heap: ReadableMemoryProperties
    val nonHeap: ReadableMemoryProperties

    init {
        ManagementFactory.getMemoryMXBean().also {
            heap = ReadableMemoryProperties(it.heapMemoryUsage)
            nonHeap = ReadableMemoryProperties(it.nonHeapMemoryUsage)
        }
    }
}