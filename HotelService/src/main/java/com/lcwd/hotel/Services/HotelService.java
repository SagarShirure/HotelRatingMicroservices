package com.lcwd.hotel.Services;

import com.lcwd.hotel.HotelServiceApplication;
import com.lcwd.hotel.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel updateHotel(Hotel hotel,int hotelId);
    void delete(int hotelId);
    Hotel getById(int hotelId);
}
