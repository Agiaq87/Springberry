package it.giaquinto.springberry.utils.file

import it.giaquinto.springberry.spring.model.logger.LogMessage
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.Path
import java.nio.file.Paths

object FileUtils {
    fun makeWriter(file: File): FileWriter =
        FileWriter(file, true)

    fun makeFile(path: String): File =
        File(path)

    fun makeDirectory(path: String): Path? =
        try {
            Paths.get(path).apply {
                if (Files.notExists(this, LinkOption.NOFOLLOW_LINKS)) {
                    Files.createDirectory(this)
                }
            }
        } catch (ignored: Exception) {
            null
        }
}

fun FileWriter.write(logMessage: LogMessage) {
    write(
        "[${logMessage.logOut}] ${logMessage.date} ${logMessage.message}\n"
    )
    flush()
}