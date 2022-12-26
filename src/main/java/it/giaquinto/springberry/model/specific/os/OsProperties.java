package it.giaquinto.springberry.model.specific.os;

public class OsProperties {

    private final String arch;
    private final String name;
    private final String version;

    public OsProperties() {
        arch = System.getProperty("os.arch");
        name = System.getProperty("os.name");
        version = System.getProperty("os.version");
    }

    public String getArch() {
        return arch;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "OsProperties{" +
                "arch='" + arch + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
