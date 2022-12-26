package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.sorted.implementation.GenericSorted;
import it.giaquinto.springberry.utils.string.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class StringController implements SpringBerryController {
    @Override
    public String ID() {
        return StringController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[]{
                HttpRequest.GET
        };
    }

    @GetMapping(path = "length/{string}")
    public int length(@PathVariable final String string) {
        return string.length();
    }

    @GetMapping(path = "orderDescending/{string}")
    public String orderDescending(@PathVariable final String string) {
        return StringUtils.getInstance().revertToString(
                new GenericSorted<Character>().sortDescending(
                        StringUtils.getInstance().toList(
                                string.toCharArray()
                        )
                )
        );
    }

    @GetMapping(path = "orderGrowing/{string}")
    public String orderGrowing(@PathVariable final String string) {
        return StringUtils.getInstance().revertToString(
                new GenericSorted<Character>().sortGrowing(
                        StringUtils.getInstance().toList(
                                string.toCharArray()
                        )
                )
        );
    }

    @GetMapping(path = "palindrome/{string}")
    public boolean palindrome(@PathVariable final String string) {
        return StringUtils.getInstance().palindrome(string);
    }
}
