package it.giaquinto.springberry.component;

import it.giaquinto.springberry.spring.model.math.number.BigIntegerNumberRepresentation;
import it.giaquinto.springberry.spring.model.math.number.LongNumberRepresentation;
import it.giaquinto.springberry.spring.model.math.NumberRepresentation;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class MathComponent {

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

    public NumberRepresentation toAllBase(final Long decode) { return new LongNumberRepresentation(decode); }

    public NumberRepresentation toAllBase(final BigInteger decode) { return new BigIntegerNumberRepresentation(decode); }
}
