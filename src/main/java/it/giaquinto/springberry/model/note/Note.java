package it.giaquinto.springberry.model.note;

import java.time.LocalDateTime;

public record Note(
        String name,
        String description,
        LocalDateTime dateTime
) {


}
