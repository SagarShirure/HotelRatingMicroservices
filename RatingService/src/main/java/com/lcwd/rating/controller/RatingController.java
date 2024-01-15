package com.lcwd.rating.controller;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;



    @PostMapping("")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<>( this.ratingService.create(rating), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Rating>> getRatings(){
        return new ResponseEntity<>(this.ratingService.getAll(),HttpStatus.OK);
    }



    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
        return  new ResponseEntity<>(this.ratingService.getByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable int hotelId){
        return new ResponseEntity<>(this.ratingService.getByHotelID(hotelId), HttpStatus.OK);
    }
}
