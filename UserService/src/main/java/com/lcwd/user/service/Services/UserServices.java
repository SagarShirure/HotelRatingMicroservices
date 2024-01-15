package com.lcwd.user.service.Services;

import com.lcwd.user.service.entites.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
    User updateUser(User user, String userId);
    void deleteUser(String userId);
}
