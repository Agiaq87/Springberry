package it.giaquinto.springberry.spring.bean.springberrybean.properties

class OsProperties {
    val arch: String
        get() = System.getProperty("os.arch")
    val name: String
        get() = System.getProperty("os.name")
    val version: String
        get() = System.getProperty("os.version")

}