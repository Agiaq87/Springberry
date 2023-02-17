package it.giaquinto.springberry.spring.bean.springberrybean.properties

class SeparatorProperties {
    val file: String = System.getProperty("file.separator")
    val line: String = System.getProperty("line.separator")
    val path: String = System.getProperty("path.separator")
}