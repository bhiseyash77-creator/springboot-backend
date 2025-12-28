package com.example.yashbhise.Service;

import com.example.yashbhise.Model.User;

public interface UserService {

    User adduser(User user );
    boolean loginUser(String username, String password);
}
