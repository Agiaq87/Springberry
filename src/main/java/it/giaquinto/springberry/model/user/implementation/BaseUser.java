package it.giaquinto.springberry.model.user.implementation;

import it.giaquinto.springberry.model.user.User;

public abstract class BaseUser implements User {

    private final String name;
    private final String surname;

    public BaseUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "BaseUser[]";
    }
}
