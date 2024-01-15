package com.lcwd.hotel.Services;

import com.lcwd.hotel.Exception.ResourceNotFound;
import com.lcwd.hotel.Repositiries.HotelRepository;
import com.lcwd.hotel.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(Hotel hotel, int hotelId)  {

        Hotel hotel1=this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFound("Resource not found !!"));
        hotel.setHotelId(hotelId);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public void delete(int hotelId) {
        this.hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel getById(int hotelId) {
        Hotel hotel1=this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFound("Resource not found !!"));
        return hotel1;
    }
}
