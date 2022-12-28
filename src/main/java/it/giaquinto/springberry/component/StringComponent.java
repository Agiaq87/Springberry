package it.giaquinto.springberry.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class StringComponent {

    public List<Character> toList(final char[] string) {
        var returnedList = new LinkedList<Character>();

        for (char c: string) {
            returnedList.add(c);
        }

        return returnedList;
    }

    public String revertToString(final Collection<Character> collection) {
        var stringBuilder = new StringBuilder();

        for (Character c: collection) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public boolean palindrome(final String string) {
        var temp = string.toCharArray();
        var returnedValue = false;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == temp[temp.length -1 - i]) {
                returnedValue = true;
            } else {
                break;
            }
        }

        return returnedValue;
    }
}