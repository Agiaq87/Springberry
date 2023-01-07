package it.giaquinto.springberry.model.math.number;

import it.giaquinto.springberry.model.math.NumberRepresentation;

import java.util.Objects;

public final class LongNumberRepresentation extends NumberRepresentation {
    private final long defaultBase;
    private final String binary;
    private final String octal;
    private final String hex;

    public LongNumberRepresentation(final long value) {
        this.defaultBase = value;
        final Long decode = value;
        binary = Long.toBinaryString(value);
        octal = String.format("%o", decode);
        hex = String.format("%X", decode);
    }

    public String getBinary() {
        return binary;
    }

    public String getOctal() {
        return octal;
    }

    @Override
    public String getValue() {
        return Long.toString(defaultBase);
    }

    public String getHex() {
        return hex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongNumberRepresentation that)) return false;
        return defaultBase == that.defaultBase && Objects.equals(binary, that.binary) && Objects.equals(octal, that.octal) && Objects.equals(hex, that.hex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultBase, binary, octal, hex);
    }

    @Override
    public String toString() {
        return "NumberRepresentation{" +
                "value=" + defaultBase +
                ", binary='" + binary + '\'' +
                ", octal='" + octal + '\'' +
                ", hex='" + hex + '\'' +
                '}';
    }
}
