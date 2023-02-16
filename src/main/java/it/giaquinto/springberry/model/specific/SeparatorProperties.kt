package it.giaquinto.springberry.model.specific

class SeparatorProperties {
    val file: String
    val line: String
    val path: String

    init {
        file = System.getProperty("file.separator")
        line = System.getProperty("line.separator")
        path = System.getProperty("path.separator")
    }

    override fun toString(): String {
        return "SeparatorProperties{" +
                "file='" + file + '\'' +
                ", line='" + line + '\'' +
                ", path='" + path + '\'' +
                '}'
    }
}