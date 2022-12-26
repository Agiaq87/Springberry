package it.giaquinto.springberry.model.specific.java;

public final class JavaVmProperties {

    private final String name;
    private final String version;

    private final String vendor;

    public JavaVmProperties() {
        name = System.getProperty("java.vm.name");
        version = System.getProperty("java.vm.version");
        vendor = System.getProperty("java.vm.vendor");
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public String toString() {
        return "JavaVmProperties{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
