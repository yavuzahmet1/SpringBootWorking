package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contents = new ArrayList<>();
}
///Spring Boot tutorials dakika 1.00'de kaldım