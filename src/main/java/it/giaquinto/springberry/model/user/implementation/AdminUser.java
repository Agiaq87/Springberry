package it.giaquinto.springberry.model.user.implementation;

import it.giaquinto.springberry.model.security.SecurityLevel;

public final class AdminUser extends BaseUser {

    public AdminUser(String name, String surname) {
        super(name, surname);
    }

    @Override
    public SecurityLevel levelOf() {
        return SecurityLevel.ADMIN;
    }
}
