package it.giaquinto.springberry.model.user.implementation;

import it.giaquinto.springberry.model.security.SecurityLevel;

import java.time.LocalDateTime;

public final class AdminUser extends BaseUser {

    public AdminUser(
            final String name,
            final String surname,
            final LocalDateTime created
    ) {
        super(name, surname, created);
    }

    @Override
    public SecurityLevel levelOf() {
        return SecurityLevel.ADMIN;
    }


}
