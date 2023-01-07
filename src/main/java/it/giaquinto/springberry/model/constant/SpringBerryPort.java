package it.giaquinto.springberry.model.constant;

public enum SpringBerryPort {
    DEFAULT(9090);


    private final int portValue;
    SpringBerryPort(final int port) {
        this.portValue = port;
    }

    public final int getPortValue() {
        return portValue;
    }
}
