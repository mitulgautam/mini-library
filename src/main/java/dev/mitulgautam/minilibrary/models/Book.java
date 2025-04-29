package dev.mitulgautam.minilibrary.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import jakarta.persistence.PrePersist;

import java.util.UUID;

@Entity
@Getter
public class Book {
    @Id
    @NotNull
    @Column(nullable = false)
    UUID bookId;

    @Column(nullable = false)
    @Size(min = 5, max = 255, message = "Book title should be between 5 and 255 characters.")
    String title;

    @Column(nullable = false)
    @Size(min = 5, max = 255, message = "Book author should be between 5 and 255 characters.")
    String author;

    @Column(nullable = false)
    boolean available;

    @PrePersist
    public void prePersist() {
        if (bookId == null) {
            bookId = UUID.randomUUID();
        }
    }
}
