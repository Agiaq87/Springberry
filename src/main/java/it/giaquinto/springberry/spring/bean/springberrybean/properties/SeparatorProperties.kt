package it.giaquinto.springberry.model.specific;

public final class SeparatorProperties {
    private final String file;
    private final String line;
    private final String path;

    public SeparatorProperties() {
        file = System.getProperty("file.separator");
        line = System.getProperty("line.separator");
        path = System.getProperty("path.separator");
    }

    public String getFile() {
        return file;
    }

    public String getLine() {
        return line;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "SeparatorProperties{" +
                "file='" + file + '\'' +
                ", line='" + line + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
