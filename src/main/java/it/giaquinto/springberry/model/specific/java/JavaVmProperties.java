package it.giaquinto.springberry.model.specific.java;

public final class JavaVmProperties {

    private final String info;
    private final String name;
    private final String vendor;
    private final String version;

    public JavaVmProperties() {
        info = System.getProperty("java.vm.info");
        name = System.getProperty("java.vm.name");
        version = System.getProperty("java.vm.version");
        vendor = System.getProperty("java.vm.vendor");
    }

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "JavaVmProperties{" +
                "info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
