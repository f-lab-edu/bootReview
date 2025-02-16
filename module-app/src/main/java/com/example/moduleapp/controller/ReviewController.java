package com.example.moduleapp.controller;

import com.example.modulecore.dto.ReviewDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "리뷰 API", description = "도서 리뷰 관련 API")
public class ReviewController {
    @GetMapping("/{bookId}/review")
    @Operation(summary = "도서 리뷰 조회", description = "특정 도서의 리뷰 목록을 조회합니다.")
    public ResponseEntity<ReviewDto> getReview(@PathVariable Long bookId) {
        return ResponseEntity.ok(new ReviewDto(1L, bookId, 1L, "book content", "book summary", 4.5));
    }
}