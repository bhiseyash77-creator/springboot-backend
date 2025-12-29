package com.example.yashbhise.Service;

import com.example.yashbhise.Model.Userapp;

public interface UserService {

    Userapp adduser(Userapp user );
    boolean loginUser(String username, String password);
}
