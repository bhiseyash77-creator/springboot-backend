package com.example.yashbhise.Repository;

import com.example.yashbhise.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}

