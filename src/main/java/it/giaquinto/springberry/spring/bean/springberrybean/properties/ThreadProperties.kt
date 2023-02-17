package it.giaquinto.springberry.model.specific.thread;

import it.giaquinto.springberry.model.time.OrderMagnitudeTime;
import it.giaquinto.springberry.model.time.TimeUnit;
import it.giaquinto.springberry.utils.time.TimeConverter;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ThreadProperties {

    //private final ThreadMXBean source;
    private final TimeUnit currentThreadCpuTime;
    private final TimeUnit currentThreadUserTime;
    private final int daemonCount;
    private final int peakThreadCount;
    private final int threadCount;
    private final long totalStartedThreadCount;

    private final Map<Long, ThreadInfo> threadsInfo = new HashMap<>();
    public ThreadProperties() {
        var source = ManagementFactory.getThreadMXBean();

        threadCount = source.getThreadCount();
        daemonCount = source.getDaemonThreadCount();
        peakThreadCount = source.getPeakThreadCount();
        totalStartedThreadCount = source.getTotalStartedThreadCount();
        currentThreadCpuTime = TimeConverter.getInstance().toReadableUnit(source.getCurrentThreadCpuTime(), OrderMagnitudeTime.NANO);
        currentThreadUserTime = TimeConverter.getInstance().toReadableUnit(source.getCurrentThreadUserTime(), OrderMagnitudeTime.NANO);
        var threadIds = source.getAllThreadIds();

        for (long id: threadIds) {
            threadsInfo.put(id, source.getThreadInfo(id));
        }
    }

    public TimeUnit getCurrentThreadCpuTime() {
        return currentThreadCpuTime;
    }

    public TimeUnit getCurrentThreadUserTime() {
        return currentThreadUserTime;
    }

    public int getDaemonCount() {
        return daemonCount;
    }

    public int getPeakThreadCount() {
        return peakThreadCount;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public long getTotalStartedThreadCount() {
        return totalStartedThreadCount;
    }

    public Map<Long, ThreadInfo> getThreadInfos() {
        return threadsInfo;
    }

    @Override
    public String toString() {
        return "ThreadProperties{" +
                "threadCount=" + threadCount +
                ", daemonCount=" + daemonCount +
                ", peakThreadCount=" + peakThreadCount +
                ", totalStartedThreadCount=" + totalStartedThreadCount +
                ", currentThreadCpuTime=" + currentThreadCpuTime +
                ", currentThreadUserTime=" + currentThreadUserTime +
                '}';
    }
}
