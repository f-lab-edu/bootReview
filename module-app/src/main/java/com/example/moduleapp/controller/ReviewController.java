package com.example.moduleapp.controller;

import com.example.modulecore.dto.ReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final List<ReviewDto> reviews = new ArrayList<>();

    @PostMapping
    public void addReview(@RequestBody ReviewDto reviewDto) {
        reviewDto.setId((long) (reviews.size() + 1));
        reviews.add(reviewDto);
    }

    @GetMapping("/{bookId}")
    public List<ReviewDto> getReviews(@PathVariable Long bookId) {
        List<ReviewDto> result = new ArrayList<>();
        for (ReviewDto review : reviews) {
            if (review.getBookId().equals(bookId)) {
                result.add(review);
            }
        }
        return result;
    }
}