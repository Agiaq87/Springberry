package it.giaquinto.springberry.spring.bean.springberrybean.properties

class JavaProperties {
    val compiler: String?
        get() = System.getProperty("java.compiler")
    val home: String
        get() = System.getProperty("java.home")
    val classPath: String
        get() = System.getProperty("java.class.path")
    val runtimeVersion: String
        get() = System.getProperty("java.runtime.version")
    val version: String
        get() = System.getProperty("java.version")

    val vendor: String
        get() = System.getProperty("java.vendor")
    val vendorUrl: String
        get() = System.getProperty("java.vendor.url")

    val vmInfo: String
        get() = System.getProperty("java.vm.info")
    val vmName: String
        get() = System.getProperty("java.vm.name")
    val vmVendor: String
        get() = System.getProperty("java.vm.vendor")
    val vmVersion: String
        get() = System.getProperty("java.vm.version")
}