package it.giaquinto.springberry.model.user.implementation;

import it.giaquinto.springberry.model.security.SecurityLevel;

import java.time.LocalDateTime;

public final class PowerUser extends BaseUser{

    public PowerUser(
            final String name,
            final String surname,
            final LocalDateTime created
    ) {
        super(name, surname, created);
    }

    @Override
    public SecurityLevel levelOf() {
        return SecurityLevel.POWER;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
