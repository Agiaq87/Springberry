package it.giaquinto.springberry.utils.math;

import java.math.BigInteger;

public abstract class MathUtils {

    public static BigInteger factorial(long value) {
        BigInteger returnedValue = BigInteger.valueOf(1);

        for (; value >= 2; value--) {
            returnedValue = returnedValue.multiply(BigInteger.valueOf(value));
        }

        return returnedValue;
    }

    public static String toHex(final Long decode) {
        return String.format("%X", decode);
    }

    public static String toOctal(final Long decode) {
        return String.format("%o", decode);
    }

    public static String toBinary(final Long decode) {
        return Long.toBinaryString(decode);
    }
}
