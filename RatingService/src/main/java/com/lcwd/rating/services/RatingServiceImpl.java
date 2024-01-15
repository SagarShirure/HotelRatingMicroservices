package com.lcwd.rating.services;

import com.lcwd.rating.Repository.RatingRepository;
import com.lcwd.rating.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return this.ratingRepository.findAll();
    }




    @Override
    public List<Rating> getByUserId(String userId) {
        System.out.println(this.ratingRepository.getByUserId(userId));
        return this.ratingRepository.getByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelID(int hotalId) {
        return this.ratingRepository.findByHotelId(hotalId);
    }
}
