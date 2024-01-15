package com.lcwd.user.service.Controller;

import com.lcwd.user.service.Services.UserServices;
import com.lcwd.user.service.entites.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        User user1 =this.userServices.saveUser(user);
        return  new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingFallBackMethod")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user=this.userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> ratingFallBackMethod(String userId, Exception ex){
        User user = User.builder()
                .email("NA")
                .userId("NA")
                .about("NA")
                .name("NA")
                .build();
        return  new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=this.userServices.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userId){
        User user1=this.userServices.updateUser(user,userId);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        this.userServices.deleteUser(userId);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
