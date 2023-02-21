package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.model.Status;
import dev.danvega.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1,
                "My first Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contents.add(c);
        Content c1 = new Content(2,
                "My Second Blog Post",
                "My second blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contents.add(c1);
    }

    public void save(Content content) {
        contents.removeIf(c -> c.id().equals(content.id()));
        contents.add(content);
    }

    public boolean existById(Integer id) {
        return contents.stream()
                .filter(c -> c.id().equals(id))
                .count() == 1;
    }

    public void delete(Integer id) {
        contents.removeIf(c -> c.id().equals(id));
    }

}
