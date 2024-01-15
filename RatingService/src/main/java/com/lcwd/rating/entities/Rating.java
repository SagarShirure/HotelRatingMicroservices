package com.lcwd.rating.entities;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private int hotelId;
    private int rating;
    private String feedback;
}
