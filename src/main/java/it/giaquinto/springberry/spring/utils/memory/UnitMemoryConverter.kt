package it.giaquinto.springberry.spring.utils.memory

object UnitMemoryConverter {
    fun toKiloByte(byteValue: Long): Long {
        return byteValue / 1024
    }

    fun toMegaByte(byteValue: Long): Long {
        return byteValue / 1048576
    }

    fun toGigaByte(byteValue: Long): Long {
        return byteValue / 1073741824
    }
}