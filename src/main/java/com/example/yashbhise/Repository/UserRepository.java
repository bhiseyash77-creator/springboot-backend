package com.example.yashbhise.Repository;

import com.example.yashbhise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsernameAndPassword(String username, String password);
}
