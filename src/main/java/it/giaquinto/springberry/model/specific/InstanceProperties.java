package it.giaquinto.springberry.model.specific;

import it.giaquinto.springberry.model.security.SecurityLevel;
import it.giaquinto.springberry.model.specific.java.JavaProperties;
import it.giaquinto.springberry.model.specific.java.JavaVendorProperties;
import it.giaquinto.springberry.model.specific.java.JavaVmProperties;
import it.giaquinto.springberry.model.specific.memory.MemoryProperties;
import it.giaquinto.springberry.model.specific.os.OsProperties;
import it.giaquinto.springberry.model.specific.runtime.RuntimeProperties;
import it.giaquinto.springberry.model.specific.thread.ThreadProperties;

import java.lang.management.ManagementFactory;

public final class InstanceProperties {

    private final SecurityLevel level;

    private final JavaProperties javaProperties;
    private final JavaVendorProperties javaVendorProperties;

    private final JavaVmProperties javaVmProperties;

    private final MemoryProperties memoryProperties;
    private final OsProperties osProperties;

    private final RuntimeProperties runtimeProperties;
    private final SeparatorProperties separatorProperties;
    private final ThreadProperties threadProperties;
    private final UserProperties userProperties;

    public InstanceProperties(final SecurityLevel level) {
        this.level = level;

        javaProperties = new JavaProperties();
        javaVendorProperties = new JavaVendorProperties();
        javaVmProperties = new JavaVmProperties();
        memoryProperties = new MemoryProperties(level);
        osProperties = new OsProperties();
        runtimeProperties = new RuntimeProperties();
        separatorProperties = new SeparatorProperties();
        threadProperties = new ThreadProperties();
        userProperties = new UserProperties();

    }

    public SecurityLevel getLevel() {
        return level;
    }

    public JavaProperties getJavaProperties() {
        return javaProperties;
    }

    public JavaVendorProperties getJavaVendorProperties() {
        return javaVendorProperties;
    }

    public JavaVmProperties getJavaVmProperties() {
        return javaVmProperties;
    }

    public MemoryProperties getMemoryProperties() {
        return memoryProperties;
    }

    public OsProperties getOsProperties() {
        return osProperties;
    }

    public RuntimeProperties getRuntimeProperties() {
        return runtimeProperties;
    }

    public SeparatorProperties getSeparatorProperties() {
        return separatorProperties;
    }

    public ThreadProperties getThreadProperties() {
        return threadProperties;
    }

    public UserProperties getUserProperties() {
        return userProperties;
    }

    @Override
    public String toString() {
        return "InstanceProperties{" +
                "level=" + level +
                ", javaProperties=" + javaProperties +
                ", javaVendorProperties=" + javaVendorProperties +
                ", javaVmProperties=" + javaVmProperties +
                ", memoryProperties=" + memoryProperties +
                ", osProperties=" + osProperties +
                ", runtimeProperties=" + runtimeProperties +
                ", separatorProperties=" + separatorProperties +
                ", threadProperties=" + threadProperties +
                ", userProperties=" + userProperties +
                '}';
    }

    // TODO
    public String properties() {
        return switch (level) {
            case NONE -> "Nothing to show";
            case USER -> "Nothing to show";
            case POWER -> "Nothing to show";
            case ADMIN -> "TODO";
        };
    }
}
