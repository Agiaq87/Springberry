package it.giaquinto.springberry.utils.string;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class StringUtils {

    private static StringUtils INSTANCE = null;

    private StringUtils() {}

    public static StringUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StringUtils();
        }

        return INSTANCE;
    }

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
