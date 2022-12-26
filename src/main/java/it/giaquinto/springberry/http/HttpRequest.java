package it.giaquinto.springberry.http;

import org.springframework.web.bind.annotation.RequestMethod;

public enum HttpRequest {
    GET,
    HEAD,
    POST,
    PUT,
    DELETE,
    OPTIONS,
    TRACE,
    PATCH;


    public static RequestMethod get(final HttpRequest toConvert) {
        return switch (toConvert) {
            case GET -> RequestMethod.GET;
            case HEAD -> RequestMethod.HEAD;
            case POST -> RequestMethod.POST;
            case PUT -> RequestMethod.PUT;
            case DELETE -> RequestMethod.DELETE;
            case OPTIONS -> RequestMethod.OPTIONS;
            case TRACE -> RequestMethod.TRACE;
            case PATCH -> RequestMethod.PATCH;
        };
    }
}
