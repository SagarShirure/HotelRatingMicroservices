package com.lcwd.hotel.controller;

import com.lcwd.hotel.Services.HotelService;
import com.lcwd.hotel.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1=this.hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> listOfHotel=this.hotelService.getAllHotels();
        return new ResponseEntity<>(listOfHotel,HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable int hotelId){
        Hotel hotel=this.hotelService.getById(hotelId);
        return  new ResponseEntity<>(hotel,HttpStatus.OK);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable int hotelId){
        Hotel hotel1=this.hotelService.updateHotel(hotel,hotelId);
        return  new ResponseEntity<>(hotel1,HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable int hotelId){
        this.hotelService.delete(hotelId);
        return  new ResponseEntity<>("Hotel deleted sucessfully",HttpStatus.OK);
    }
}
