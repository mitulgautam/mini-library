package dev.mitulgautam.minilibrary.service;

import dev.mitulgautam.minilibrary.models.Book;
import dev.mitulgautam.minilibrary.repo.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Transactional
    public Book insertBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
}
