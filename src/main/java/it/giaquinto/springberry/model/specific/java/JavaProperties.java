package it.giaquinto.springberry.model.specific.java;

public final class JavaProperties {

    private final String compiler;
    private final String home;
    private final String path;
    private final String runtime;
    private final String version;

    public JavaProperties() {
        compiler = System.getProperty("java.compiler");
        home = System.getProperty("java.home");
        path = System.getProperty("java.class.path");
        version = System.getProperty("java.version");
        runtime = System.getProperty("java.runtime.version");
    }

    public String getCompiler() {
        return compiler;
    }

    public String getHome() {
        return home;
    }

    public String getPath() {
        return path;
    }

    public String getVersion() {
        return version;
    }

    public String getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return "JavaProperties{" +
                "compiler='" + compiler + '\'' +
                ", home='" + home + '\'' +
                ", path='" + path + '\'' +
                ", runtime='" + runtime + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
