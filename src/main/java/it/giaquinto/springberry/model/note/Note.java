package it.giaquinto.springberry.model.note;

import it.giaquinto.springberry.model.user.User;

import java.time.LocalDateTime;

public record Note(
        String name,
        String description,
        LocalDateTime dateTime,
        User user
) {

}
