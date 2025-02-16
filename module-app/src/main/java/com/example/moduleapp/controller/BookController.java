package com.example.moduleapp.controller;

import com.example.modulecore.dto.BookDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final List<BookDto> books = new ArrayList<>();

    @GetMapping("/search")
    public List<BookDto> searchBooks(@RequestParam String keyword) {
        List<BookDto> result = new ArrayList<>();
        for (BookDto book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        bookDto.setId((long) (books.size() + 1));
        books.add(bookDto);
    }
}