package com.devmare.user.service.service.impl;

import com.devmare.user.service.entity.Hotel;
import com.devmare.user.service.entity.Rating;
import com.devmare.user.service.entity.User;
import com.devmare.user.service.exception.ResourceNotFoundException;
import com.devmare.user.service.external.services.HotelService;
import com.devmare.user.service.repository.UserRepository;
import com.devmare.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User createUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id: " + userId));
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);

        assert ratingsOfUser != null;
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(
                ratingObj -> {
                    // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + ratingObj.getHotelId(), Hotel.class);
                    // Hotel hotel = forEntity.getBody();
                    Hotel hotel = hotelService.getHotel(ratingObj.getHotelId());
                    ratingObj.setHotel(hotel);
                    return ratingObj;
                }
        ).toList();

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User updateUser(User user, String userId) {
        User updatedUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        updatedUser.setName(user.getName());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setPhone(user.getPhone());
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
