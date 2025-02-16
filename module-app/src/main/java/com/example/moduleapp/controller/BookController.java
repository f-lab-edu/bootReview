package com.example.moduleapp.controller;

import com.example.modulecore.dto.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "도서 API", description = "도서 검색 및 정보 제공 API")
public class BookController {

    @GetMapping("/search")
    @Operation(summary = "도서 검색", description = "제목, 저자, 장르를 기반으로 도서를 검색합니다.")
    public ResponseEntity<List<BookDto>> searchBooks(
            @RequestParam String query,
            @RequestParam(required = false) String genre) {

        // 더미 데이터 반환 (실제 DB 연동 필요)
        List<BookDto> books = List.of(
                new BookDto(1L, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 4.5),
                new BookDto(2L, "1984", "George Orwell", "Dystopian", 4.7),
                new BookDto(3L, "To Kill a Mockingbird", "Harper Lee", "Fiction", 4.8)
        );

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    @Operation(summary = "도서 상세 정보 조회", description = "책 ID를 이용하여 도서 상세 정보를 조회합니다.")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) {
        // 더미 데이터 반환 (실제 DB 연동 필요)
        BookDto book = new BookDto(bookId, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 4.5);
        return ResponseEntity.ok(book);
    }
}