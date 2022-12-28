package it.giaquinto.springberry.model.user.implementation;

import it.giaquinto.springberry.model.user.User;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class BaseUser implements User {

    private final String name;
    private final String surname;

    private final LocalDateTime created;

    public BaseUser(
            final String name,
            final String surname,
            final LocalDateTime created
    ) {
        this.name = name;
        this.surname = surname;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseUser baseUser)) return false;
        return Objects.equals(name, baseUser.name) && Objects.equals(surname, baseUser.surname) && Objects.equals(created, baseUser.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, created);
    }
}
