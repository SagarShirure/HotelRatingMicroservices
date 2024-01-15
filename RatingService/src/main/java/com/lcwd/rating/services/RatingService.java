package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RatingService {

    Rating create(Rating rating);
    List<Rating> getAll();



    List<Rating> getByUserId(String userId);

    List<Rating> getByHotelID(int hotalId);


}
