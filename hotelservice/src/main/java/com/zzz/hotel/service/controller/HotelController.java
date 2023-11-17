package com.zzz.hotel.service.controller;

import com.zzz.hotel.service.entity.Hotel;
import com.zzz.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(
            @RequestBody Hotel hotel
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelService.createHotel(hotel));
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(
            @PathVariable String hotelId
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelService.getHotel(hotelId));
    }
}
