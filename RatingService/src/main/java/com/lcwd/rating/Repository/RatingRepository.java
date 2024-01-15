package com.lcwd.rating.Repository;

import com.lcwd.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,Integer> {


    @Query("{userId:?0} ")
    List<Rating> getByUserId(String userId);
    List<Rating> findByHotelId(int hotelId);
}
