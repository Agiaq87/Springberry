package it.giaquinto.springberry.component

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class StringComponent {
    fun toList(string: CharArray): List<Char> {
        val returnedList = LinkedList<Char>()
        for (c in string) {
            returnedList.add(c)
        }
        return returnedList
    }

    fun revertToString(collection: Collection<Char?>): String {
        val stringBuilder = StringBuilder()
        for (c in collection) {
            stringBuilder.append(c)
        }
        return stringBuilder.toString()
    }

    fun palindrome(string: String): Boolean {
        val temp = string.toCharArray()
        var returnedValue = false
        for (i in temp.indices) {
            returnedValue = if (temp[i] == temp[temp.size - 1 - i]) {
                true
            } else {
                break
            }
        }
        return returnedValue
    }
}