package it.giaquinto.springberry.model.specific.memory;

import it.giaquinto.springberry.model.security.SecurityLevel;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public final class MemoryProperties {

    private final ReadableMemoryProperties heap;

    private final ReadableMemoryProperties nonHeap;

    public MemoryProperties(final SecurityLevel level) {
        var memory = ManagementFactory.getMemoryMXBean();

        if (level == SecurityLevel.ADMIN || level == SecurityLevel.POWER) {
            memory.setVerbose(true);
        }

        heap = new ReadableMemoryProperties(memory.getHeapMemoryUsage());

        nonHeap = new ReadableMemoryProperties(memory.getNonHeapMemoryUsage());
    }

    public ReadableMemoryProperties getHeap() {
        return heap;
    }

    public ReadableMemoryProperties getNonHeap() {
        return nonHeap;
    }

    @Override
    public String toString() {
        return "MemoryProperties{" + "heap=" + heap + ", nonHeap=" + nonHeap + '}';
    }
}
