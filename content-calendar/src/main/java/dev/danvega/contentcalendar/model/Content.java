package dev.danvega.contentcalendar.model;


import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotEmpty
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url

) {


}
