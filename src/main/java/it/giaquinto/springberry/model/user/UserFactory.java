package it.giaquinto.springberry.model.user;

import it.giaquinto.springberry.model.security.SecurityLevel;
import it.giaquinto.springberry.model.user.implementation.*;

public abstract class UserFactory {
    public static BaseUser fromBaseUser(final BaseUser baseUser, final SecurityLevel level) {
        return switch(level) {
            case NONE -> null;
            case GUEST -> new GuestUser(baseUser.getName(), baseUser.getSurname(), baseUser.getCreated());
            case NORMAL -> new NormalUser(baseUser.getName(), baseUser.getSurname(), baseUser.getCreated());
            case POWER -> new PowerUser(baseUser.getName(), baseUser.getSurname(), baseUser.getCreated());
            case ADMIN -> new AdminUser(baseUser.getName(), baseUser.getSurname(), baseUser.getCreated());
        };
    }
}
