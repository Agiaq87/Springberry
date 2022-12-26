package it.giaquinto.springberry.model.specific.java;

public final class JavaVendorProperties {

    private final String name;
    private final String url;

    public JavaVendorProperties() {
        name = System.getProperty("java.vendor");
        url = System.getProperty("java.vendor.url");
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "JavaVendorProperties{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
