package it.giaquinto.springberry.model.specific.java

class JavaVmProperties {
    val info: String
    val name: String
    val vendor: String
    val version: String

    init {
        info = System.getProperty("java.vm.info")
        name = System.getProperty("java.vm.name")
        version = System.getProperty("java.vm.version")
        vendor = System.getProperty("java.vm.vendor")
    }

    override fun toString(): String {
        return "JavaVmProperties{" +
                "info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", version='" + version + '\'' +
                '}'
    }
}