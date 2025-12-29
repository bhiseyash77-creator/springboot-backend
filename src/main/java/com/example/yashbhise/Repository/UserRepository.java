package com.example.yashbhise.Repository;

import com.example.yashbhise.Model.Userapp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userapp, Integer> {

    Optional<Userapp> findByUsernameAndPassword(String username, String password);
}
