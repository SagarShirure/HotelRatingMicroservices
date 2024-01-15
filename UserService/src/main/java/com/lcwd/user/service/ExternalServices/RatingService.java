package com.lcwd.user.service.ExternalServices;

import com.lcwd.user.service.entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("/rating/user/{userId}")
    List<Rating> getRatings(@PathVariable String userId);
}
