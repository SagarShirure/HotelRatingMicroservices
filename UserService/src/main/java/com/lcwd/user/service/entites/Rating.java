package com.lcwd.user.service.entites;

import lombok.Data;

@Data
public class Rating {

    private String ratingId;
    private String userId;
    private int hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
