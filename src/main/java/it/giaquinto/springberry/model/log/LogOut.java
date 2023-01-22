package it.giaquinto.springberry.model.log;

public enum LogOut {
    DIRECT("D"),
    VERBOSE("V"),
    WARNING("W"),
    ERROR("E");

    private final String output;

    LogOut(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
