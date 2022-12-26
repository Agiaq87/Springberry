package it.giaquinto.springberry.model.specific;

public final class UserProperties {

    private final String dir;
    private final String home;
    private final String name;

    UserProperties() {
        dir = System.getProperty("user.dir");
        home = System.getProperty("user.home");
        name = System.getProperty("user.name");
    }

    public String getDir() {
        return dir;
    }

    public String getHome() {
        return home;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserProperties{" +
                "dir='" + dir + '\'' +
                ", home='" + home + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
