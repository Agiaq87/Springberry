package it.giaquinto.springberry.model.specific

class UserProperties internal constructor() {
    val dir: String
    val home: String
    val name: String

    init {
        dir = System.getProperty("user.dir")
        home = System.getProperty("user.home")
        name = System.getProperty("user.name")
    }

    override fun toString(): String {
        return "UserProperties{" +
                "dir='" + dir + '\'' +
                ", home='" + home + '\'' +
                ", name='" + name + '\'' +
                '}'
    }
}