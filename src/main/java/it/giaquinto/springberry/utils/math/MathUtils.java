package it.giaquinto.springberry.utils.math;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public final class MathUtils {

    public BigInteger factorial(long value) {
        BigInteger returnedValue = BigInteger.valueOf(1);

        for (; value >= 2; value--) {
            returnedValue = returnedValue.multiply(BigInteger.valueOf(value));
        }

        return returnedValue;
    }

    public String toHex(final Long decode) {
        return String.format("%X", decode);
    }

    public String toOctal(final Long decode) {
        return String.format("%o", decode);
    }

    public String toBinary(final Long decode) {
        return Long.toBinaryString(decode);
    }
}
