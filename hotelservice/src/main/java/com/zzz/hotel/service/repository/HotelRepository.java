package com.zzz.hotel.service.repository;

import com.zzz.hotel.service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
