package dev.mitulgautam.minilibrary.repo;

import dev.mitulgautam.minilibrary.models.Book;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepo extends JpaRepository<Book, UUID> {
    Book findByBookId(@NotNull UUID bookId);
}
