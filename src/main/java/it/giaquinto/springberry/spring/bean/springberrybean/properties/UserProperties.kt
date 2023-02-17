package it.giaquinto.springberry.spring.bean.springberrybean.properties

class UserProperties {
    val dir: String = System.getProperty("user.dir")
    val home: String = System.getProperty("user.home")
    val name: String = System.getProperty("user.name")

}