package it.giaquinto.springberry.controller.base;

import it.giaquinto.springberry.controller.SpringBerryBaseController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.sorted.implementation.GenericSorted;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class StringBaseController extends SpringBerryBaseController {
    @Override
    public String ID() {
        return StringBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[]{
                HttpRequest.GET
        };
    }

    @GetMapping(path = "string/length/{string}")
    public int length(@PathVariable final String string) {
        return string.length();
    }

    @GetMapping(path = "string/orderDescending/{string}")
    public String orderDescending(@PathVariable final String string) {
        return getStringUtils().revertToString(
                new GenericSorted<Character>().sortDescending(
                        getStringUtils().toList(
                                string.toCharArray()
                        )
                )
        );
    }

    @GetMapping(path = "string/orderGrowing/{string}")
    public String orderGrowing(@PathVariable final String string) {
        return getStringUtils().revertToString(
                new GenericSorted<Character>().sortGrowing(
                        getStringUtils().toList(
                                string.toCharArray()
                        )
                )
        );
    }

    @GetMapping(path = "string/palindrome/{string}")
    public boolean palindrome(@PathVariable final String string) {
        return getStringUtils().palindrome(string);
    }
}
