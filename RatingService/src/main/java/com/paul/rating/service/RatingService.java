package com.paul.rating.service;

import com.paul.rating.entity.Rating;

import java.util.List;

public interface RatingService {
    //? Create rating
    Rating createRating(Rating rating);

    //? Gell all rating
    List<Rating> getAllRatings();

    //? Get ratings by userId
    List<Rating> getRatingByUserId(String userId);

    //? Get ratings by hotelId
    List<Rating> getRatingByHotelId(String hotelId);

}
