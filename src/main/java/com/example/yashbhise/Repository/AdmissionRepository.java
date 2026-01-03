package com.example.yashbhise.Repository;

import com.example.yashbhise.Model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission,Long> {
    List<Admission> findByStatus(String status);
}
