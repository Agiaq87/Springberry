package it.giaquinto.springberry.spring.bean.springberrybean.properties

import it.giaquinto.springberry.model.time.OrderMagnitudeTime
import it.giaquinto.springberry.model.time.TimeUnit
import it.giaquinto.springberry.utils.time.TimeConverter
import java.lang.management.ManagementFactory
import java.lang.management.ThreadInfo

class ThreadProperties {

    val currentThreadCpuTime: TimeUnit
    val currentThreadUserTime: TimeUnit
    val daemonCount: Int
    val peakThreadCount: Int
    val threadCount: Int
    val totalStartedThreadCount: Long
    private val threadsInfo: MutableMap<Long, ThreadInfo> = HashMap()

    init {
        ManagementFactory.getThreadMXBean().also {
            threadCount = it.threadCount
            daemonCount = it.daemonThreadCount
            peakThreadCount = it.peakThreadCount
            totalStartedThreadCount = it.totalStartedThreadCount
            currentThreadCpuTime =
                TimeConverter.toReadableUnit(it.currentThreadCpuTime, OrderMagnitudeTime.NANO)
            currentThreadUserTime =
                TimeConverter.toReadableUnit(it.currentThreadUserTime, OrderMagnitudeTime.NANO)
            val threadIds = it.allThreadIds
            for (id in threadIds) {
                threadsInfo[id] = it.getThreadInfo(id)
            }
        }
    }
}