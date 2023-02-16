package it.giaquinto.springberry.model.specific.java

class JavaVendorProperties {
    val name: String
    val url: String

    init {
        name = System.getProperty("java.vendor")
        url = System.getProperty("java.vendor.url")
    }

    override fun toString(): String {
        return "JavaVendorProperties{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}'
    }
}