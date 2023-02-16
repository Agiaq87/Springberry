package it.giaquinto.springberry.model.specific.thread

import it.giaquinto.springberry.model.time.OrderMagnitudeTime
import it.giaquinto.springberry.model.time.TimeUnit
import it.giaquinto.springberry.utils.time.TimeConverter
import java.lang.management.ManagementFactory
import java.lang.management.ThreadInfo

class ThreadProperties {
    //private final ThreadMXBean source;
    val currentThreadCpuTime: TimeUnit
    val currentThreadUserTime: TimeUnit
    val daemonCount: Int
    val peakThreadCount: Int
    val threadCount: Int
    val totalStartedThreadCount: Long
    private val threadsInfo: MutableMap<Long, ThreadInfo> = HashMap()

    init {
        val source = ManagementFactory.getThreadMXBean()
        threadCount = source.threadCount
        daemonCount = source.daemonThreadCount
        peakThreadCount = source.peakThreadCount
        totalStartedThreadCount = source.totalStartedThreadCount
        currentThreadCpuTime =
            TimeConverter.getInstance().toReadableUnit(source.currentThreadCpuTime, OrderMagnitudeTime.NANO)
        currentThreadUserTime =
            TimeConverter.getInstance().toReadableUnit(source.currentThreadUserTime, OrderMagnitudeTime.NANO)
        val threadIds = source.allThreadIds
        for (id in threadIds) {
            threadsInfo[id] = source.getThreadInfo(id)
        }
    }

    val threadInfos: Map<Long, ThreadInfo>
        get() = threadsInfo

    override fun toString(): String {
        return "ThreadProperties{" +
                "threadCount=" + threadCount +
                ", daemonCount=" + daemonCount +
                ", peakThreadCount=" + peakThreadCount +
                ", totalStartedThreadCount=" + totalStartedThreadCount +
                ", currentThreadCpuTime=" + currentThreadCpuTime +
                ", currentThreadUserTime=" + currentThreadUserTime +
                '}'
    }
}