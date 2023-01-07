package it.giaquinto.springberry.model.math.number;

import it.giaquinto.springberry.model.math.NumberRepresentation;

import java.math.BigInteger;
import java.util.Objects;

public class BigIntegerNumberRepresentation extends NumberRepresentation {
    private final BigInteger defaultBase;
    private final String binary;
    private final String octal;
    private final String hex;

    public BigIntegerNumberRepresentation(BigInteger defaultBase) {
        this.defaultBase = defaultBase;
        binary = defaultBase.toString(2);
        octal = defaultBase.toString(8);
        hex = defaultBase.toString(16);
    }

    @Override
    public String getBinary() {
        return binary;
    }

    @Override
    public String getOctal() {
        return octal;
    }

    @Override
    public String getValue() {
        return defaultBase.toString();
    }

    @Override
    public String getHex() {
        return hex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BigIntegerNumberRepresentation that)) return false;
        return Objects.equals(defaultBase, that.defaultBase) && Objects.equals(binary, that.binary) && Objects.equals(octal, that.octal) && Objects.equals(hex, that.hex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultBase, binary, octal, hex);
    }

    @Override
    public String toString() {
        return "BigIntegerNumberRepresentation{" +
                "value=" + defaultBase +
                ", binary='" + binary + '\'' +
                ", octal='" + octal + '\'' +
                ", hex='" + hex + '\'' +
                '}';
    }
}
