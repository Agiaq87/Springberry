package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.model.security.SecurityLevel;
import it.giaquinto.springberry.model.user.implementation.AdminUser;
import it.giaquinto.springberry.model.user.implementation.BaseUser;
import it.giaquinto.springberry.model.user.implementation.GuestUser;
import it.giaquinto.springberry.model.user.implementation.NormalUser;
import it.giaquinto.springberry.model.user.service.UserDaoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public final class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users/search/{name}")
    public BaseUser searchName(@PathVariable final String name) {
        return userDaoService.searchName(name);
    }

    @GetMapping(path = "/users/search/{surname}")
    public BaseUser searchSurname(@PathVariable final String surname) {
        return userDaoService.searchSurname(surname);
    }

    @GetMapping(path = "/users/search/{created}")
    public List<BaseUser> searchCreated(@PathVariable final LocalDateTime created) {
        return userDaoService.searchCreated(created);
    }

    @GetMapping(path = "/users")
    public List<BaseUser> retrieveAll() {
        return userDaoService.retrieveAll();
    }

    @GetMapping(path = "/users/search/{securityLevel}")
    public List<BaseUser> retrieveAll(@PathVariable final SecurityLevel securityLevel) {
        return userDaoService.retrieveAll(securityLevel);
    }

    @PostMapping(path = "/users")
    public BaseUser createUser(@RequestBody final BaseUser baseUser) {
        return userDaoService.makeNewUser(baseUser, SecurityLevel.GUEST);
    }

    @PostMapping(path = "/users/make/admin")
    public BaseUser createAdminUser(@RequestBody final BaseUser baseUser) {
        return userDaoService.makeNewUser(baseUser, SecurityLevel.ADMIN);
    }

    @PostMapping(path = "/users/make/power")
    public BaseUser createPowerUser(@RequestBody final BaseUser baseUser) {
        return userDaoService.makeNewUser(baseUser, SecurityLevel.POWER);
    }

    @PostMapping(path = "/users/make/normal")
    public BaseUser createNormalUser(@RequestBody final BaseUser baseUser) {
        return userDaoService.makeNewUser(baseUser, SecurityLevel.NORMAL);
    }

    @PostMapping(path = "/users/make/guest")
    public BaseUser createGuestUser(@RequestBody final BaseUser baseUser) {
        return userDaoService.makeNewUser(baseUser, SecurityLevel.GUEST);
    }
}
