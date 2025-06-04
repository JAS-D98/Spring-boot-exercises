package com.jaspercode.springboot_rest_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jaspercode.springboot_rest_api.api.model.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        userList.add(new User(1, "James", 23, "james@gmail.com"));
        userList.add(new User(2, "Alice", 28, "alice@gmail.com"));
        userList.add(new User(3, "Bob", 31, "bob@gmail.com"));
        userList.add(new User(4, "Diana", 25, "diana@gmail.com"));
    }

    public User getUser(Integer id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
