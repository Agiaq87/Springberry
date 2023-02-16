package it.giaquinto.springberry.model.specific.java

class JavaProperties {
    val compiler: String
    val home: String
    val path: String
    val runtime: String
    val version: String

    init {
        compiler = System.getProperty("java.compiler")
        home = System.getProperty("java.home")
        path = System.getProperty("java.class.path")
        version = System.getProperty("java.version")
        runtime = System.getProperty("java.runtime.version")
    }

    override fun toString(): String {
        return "JavaProperties{" +
                "compiler='" + compiler + '\'' +
                ", home='" + home + '\'' +
                ", path='" + path + '\'' +
                ", runtime='" + runtime + '\'' +
                ", version='" + version + '\'' +
                '}'
    }
}