package it.giaquinto.springberry.spring.bean.springberrybean

import it.giaquinto.springberry.model.specific.memory.ReadableMemoryProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.ThreadProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.UserProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.SeparatorProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.MemoryProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.JavaProperties
import it.giaquinto.springberry.spring.bean.SpringBerryBean
import it.giaquinto.springberry.spring.bean.springberrybean.properties.OsProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.RuntimeProperties
import it.giaquinto.springberry.spring.configuration.Identifier

class HardwareSoftwareProperties: SpringBerryBean {
    override fun getId(): Identifier = this.javaClass.packageName

    val javaProperties: JavaProperties by lazy {
        JavaProperties()
    }

    val memoryProperties: MemoryProperties by lazy {
        MemoryProperties()
    }

    val operatingSystem: OsProperties by lazy {
        OsProperties()
    }

    val runtimeProperties: RuntimeProperties by lazy {
        RuntimeProperties()
    }

    val separatorProperties: SeparatorProperties by lazy {
        SeparatorProperties()
    }

    val threadProperties: ThreadProperties by lazy {
        ThreadProperties()
    }

    val userProperties: UserProperties by lazy {
        UserProperties()
    }
}