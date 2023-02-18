package it.giaquinto.springberry.utils.memory;

public abstract class UnitMemoryConverter {

    public static long toKiloByte(final long byteValue) {
        return byteValue/1024;
    }

    public static long toMegaByte(final long byteValue) {
        return byteValue/1048576;
    }

    public static long toGigaByte(final long byteValue) {
        return byteValue/1073741824;
    }
}
