package it.giaquinto.springberry.model.specific.os

class OsProperties {
    val arch: String
    val name: String
    val version: String

    init {
        arch = System.getProperty("os.arch")
        name = System.getProperty("os.name")
        version = System.getProperty("os.version")
    }

    override fun toString(): String {
        return "OsProperties{" +
                "arch='" + arch + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}'
    }
}