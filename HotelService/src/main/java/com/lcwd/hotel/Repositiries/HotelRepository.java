package com.lcwd.hotel.Repositiries;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
