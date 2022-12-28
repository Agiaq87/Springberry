package it.giaquinto.springberry.model.user.service;

import it.giaquinto.springberry.model.security.SecurityLevel;
import it.giaquinto.springberry.model.user.UserFactory;
import it.giaquinto.springberry.model.user.implementation.BaseUser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface UserDaoService {

    BaseUser searchName(final String name);

    BaseUser searchSurname(final String surname);

    List<BaseUser> searchCreated(final LocalDateTime localDateTime);

    List<BaseUser> retrieveAll();

    List<BaseUser> retrieveAll(final SecurityLevel level);

    default BaseUser makeNewUser(final BaseUser user, final SecurityLevel level) {
        return UserFactory.fromBaseUser(user, level);
    }

}
