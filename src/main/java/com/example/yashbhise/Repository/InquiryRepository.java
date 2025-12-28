package com.example.yashbhise.Repository;

import com.example.yashbhise.Model.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    List<Inquiry> findByStatus(String status);
}

