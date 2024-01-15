package com.lcwd.user.service.Services;

import com.lcwd.user.service.ExternalServices.HotelService;
import com.lcwd.user.service.ExternalServices.RatingService;
import com.lcwd.user.service.Repositories.UserRepository;
import com.lcwd.user.service.entites.Hotel;
import com.lcwd.user.service.entites.Rating;
import com.lcwd.user.service.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;
    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> users=this.userRepository.findAll();
        List<User> userList=  users.stream().map(
                user -> {
                    Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(), Rating[].class);

                    List<Rating> ratingList=Arrays.asList(forObject);

                    List<Rating> ratings=     ratingList.stream().map(
                            rating-> {
                                Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
                                rating.setHotel(hotel);
                                return rating;
                            }).collect(Collectors.toList());
                    user.setRatings(ratings);
                    return user;
                }
        ).collect(Collectors.toList());

        return userList ;
    }

    @Override
    public User getUser(String userId) {

        User user=this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found  :" + userId));
        //Using rest Template
        //Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(), Rating[].class);

        //List<Rating> ratingList=Arrays.asList(forObject);

        List<Rating> ratingList= ratingService.getRatings(user.getUserId());
        List<Rating> ratings=     ratingList.stream().map(
                rating-> {
                    //Using Rest template
                   //Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);

                    //using feign client
                    Hotel hotel=hotelService.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }

    @Override
    public User updateUser(User user, String userId) {
       //User user1= this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found  :" + userId));
       user.setUserId(userId);
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        this.userRepository.deleteById(userId);
    }
}
