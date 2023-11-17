package com.paul.rating.controller;

import com.paul.rating.entity.Rating;
import com.paul.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ratingService.createRating(rating));
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> createRating() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(
            @PathVariable String userId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(
            @PathVariable String hotelId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ratingService.getRatingByHotelId(hotelId));
    }
}
