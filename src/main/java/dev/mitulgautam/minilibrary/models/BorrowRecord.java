package dev.mitulgautam.minilibrary.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class BorrowRecord {
    @Id
    @NotNull
    UUID borrowerRecordId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    LocalDateTime borrowedDate;

    LocalDateTime returnedDate;

    @PrePersist
    public void prePersist() {
        if (borrowerRecordId == null) {
            borrowerRecordId = UUID.randomUUID();
        }
    }
}
