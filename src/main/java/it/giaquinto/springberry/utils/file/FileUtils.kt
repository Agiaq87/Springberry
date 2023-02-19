package it.giaquinto.springberry.utils.file

import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.Path
import java.nio.file.Paths

object FileUtils {
    @JvmStatic
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

    /**
     * The name of file consist in date
     * @param path
     * @param datePattern
     * @return
     */
    @JvmStatic
    fun makeFile(path: String, datePattern: String, currentDate: String): PrintWriter? {
        return try {
            PrintWriter(
                FileWriter(
                    String.format(
                        "%s/%s.log",
                        path,
                        currentDate
                    ),
                    true
                )
            )
        } catch (e: IOException) {
            null
        }
    }
}