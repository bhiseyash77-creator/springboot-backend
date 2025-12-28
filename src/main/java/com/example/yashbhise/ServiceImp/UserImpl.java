package com.example.yashbhise.ServiceImp;

import com.example.yashbhise.Model.User;
import com.example.yashbhise.Repository.UserRepository;
import com.example.yashbhise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserImpl  implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User adduser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean loginUser(String username, String password) {

        return userRepo
                .findByUsernameAndPassword(username, password)
                .isPresent();
    }
}
