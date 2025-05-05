package dev.mitulgautam.minilibrary.controllers;

import dev.mitulgautam.minilibrary.models.Book;
import dev.mitulgautam.minilibrary.responseDto.ResponseDto;
import dev.mitulgautam.minilibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/books")
public class BookController {
    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getBook() {
        try {
            List<Book> savedBooks = bookService.getAllBooks();
            return ResponseEntity.ok(savedBooks);
        } catch (Exception e) {
            e.printStackTrace(); // Log full error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseDto<Book>> createBook(@Valid @RequestBody Book book) {
        ResponseDto<Book> responseDto = new ResponseDto<>();
        try {
            if (book.getBookId() == null) {
                book.setBookId(UUID.randomUUID());
            }

            if (book.getTitle() == null || book.getAuthor() == null) {
                responseDto.setError("Book title and author are required");
                return ResponseEntity.badRequest().build();
            }

            Book savedBook = bookService.insertBook(book);
            responseDto.setData(savedBook);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            e.printStackTrace(); // Log full error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }
}
