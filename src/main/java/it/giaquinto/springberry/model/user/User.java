package it.giaquinto.springberry.model.user;

import it.giaquinto.springberry.model.security.SecurityLevel;

public interface User {
    SecurityLevel levelOf();
}
