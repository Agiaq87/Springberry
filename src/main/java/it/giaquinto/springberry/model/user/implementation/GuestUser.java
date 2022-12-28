package it.giaquinto.springberry.model.user.implementation;

import it.giaquinto.springberry.model.security.SecurityLevel;

import java.time.LocalDateTime;

public final class GuestUser extends BaseUser{

    public GuestUser(
            final String name,
            final String surname,
            final LocalDateTime created
    ) {
        super(name, surname, created);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public SecurityLevel levelOf() {
        return SecurityLevel.GUEST;
    }
}
