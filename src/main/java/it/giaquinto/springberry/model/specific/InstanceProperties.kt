package it.giaquinto.springberry.model.specific

import it.giaquinto.springberry.model.security.SecurityLevel
import it.giaquinto.springberry.model.specific.java.JavaProperties
import it.giaquinto.springberry.model.specific.java.JavaVendorProperties
import it.giaquinto.springberry.model.specific.java.JavaVmProperties
import it.giaquinto.springberry.model.specific.memory.MemoryProperties
import it.giaquinto.springberry.model.specific.os.OsProperties
import it.giaquinto.springberry.model.specific.runtime.RuntimeProperties
import it.giaquinto.springberry.model.specific.thread.ThreadProperties

class InstanceProperties(val level: SecurityLevel) {
    val javaProperties: JavaProperties
    val javaVendorProperties: JavaVendorProperties
    val javaVmProperties: JavaVmProperties
    val memoryProperties: MemoryProperties
    val osProperties: OsProperties
    val runtimeProperties: RuntimeProperties
    val separatorProperties: SeparatorProperties
    val threadProperties: ThreadProperties
    val userProperties: UserProperties

    init {
        javaProperties = JavaProperties()
        javaVendorProperties = JavaVendorProperties()
        javaVmProperties = JavaVmProperties()
        memoryProperties = MemoryProperties(level)
        osProperties = OsProperties()
        runtimeProperties = RuntimeProperties()
        separatorProperties = SeparatorProperties()
        threadProperties = ThreadProperties()
        userProperties = UserProperties()
    }

    override fun toString(): String {
        return "InstanceProperties{" +
                "level=" + level +
                ", javaProperties=" + javaProperties +
                ", javaVendorProperties=" + javaVendorProperties +
                ", javaVmProperties=" + javaVmProperties +
                ", memoryProperties=" + memoryProperties +
                ", osProperties=" + osProperties +
                ", runtimeProperties=" + runtimeProperties +
                ", separatorProperties=" + separatorProperties +
                ", threadProperties=" + threadProperties +
                ", userProperties=" + userProperties +
                '}'
    }

    // TODO
    fun properties(): String {
        return when (level) {
            SecurityLevel.NORMAL, SecurityLevel.NONE, SecurityLevel.GUEST, SecurityLevel.POWER -> "Nothing to show"
            SecurityLevel.ADMIN -> "TODO"
        }
    }
}