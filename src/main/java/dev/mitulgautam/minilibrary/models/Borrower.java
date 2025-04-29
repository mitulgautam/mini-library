package dev.mitulgautam.minilibrary.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Borrower {
    @Id
    @NotNull
    @Column(nullable = false)
    UUID borrowerId;

    @NotNull
    @Column(nullable = false)
    String name;

    @NotNull
    @Column(nullable = false)
    String email;

    @PrePersist
    public void prePersist() {
        if (borrowerId == null) {
            borrowerId = UUID.randomUUID();
        }
    }
}
