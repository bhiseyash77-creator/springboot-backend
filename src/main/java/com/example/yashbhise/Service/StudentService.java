package com.example.yashbhise.Service;

import com.example.yashbhise.Model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student s);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(int id, Student newdata);

    String deleteStudent(int id);
}
