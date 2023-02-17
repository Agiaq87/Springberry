package it.giaquinto.springberry.model.specific.memory;

import it.giaquinto.springberry.utils.memory.UnitMemoryConverter;

import java.lang.management.MemoryUsage;

public final class ReadableMemoryProperties {

    private final MemoryUsage source;

    private final String initMB;
    private final String usedMB;
    private final String committedMB;
    private final String maxMB;

    public ReadableMemoryProperties(
            final MemoryUsage memoryUsage
            ) {
        source = memoryUsage;

        initMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(memoryUsage.getInit()));
        usedMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(memoryUsage.getUsed()));
        committedMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(memoryUsage.getCommitted()));
        maxMB = String.format("%d MB", UnitMemoryConverter.toMegaByte(memoryUsage.getMax()));
    }

    public MemoryUsage getSource() {
        return source;
    }

    public String getInitMB() {
        return initMB;
    }

    public String getUsedMB() {
        return usedMB;
    }

    public String getCommittedMB() {
        return committedMB;
    }

    public String getMaxMB() {
        return maxMB;
    }

    @Override
    public String toString() {
        return "ReadableMemoryProperties{" +
                "source=" + source +
                ", initMB='" + initMB + '\'' +
                ", usedMB='" + usedMB + '\'' +
                ", committedMB='" + committedMB + '\'' +
                ", maxMB='" + maxMB + '\'' +
                '}';
    }
}
