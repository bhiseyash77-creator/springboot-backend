package com.example.yashbhise.ServiceImp;

import com.example.yashbhise.Model.Student;
import com.example.yashbhise.Repository.StudentRepo;
import com.example.yashbhise.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class StudentImp implements StudentService {


    @Autowired
    StudentRepo repo;


    @Override
    public Student addStudent(Student s) {
        return repo.save(s);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(int id, Student newdata) {
        Optional<Student> op = repo.findById(id);

        if (op.isPresent()) {
            Student s = op.get();

            s.setName(newdata.getName());
            s.setAddress(newdata.getAddress());
            s.setAge(newdata.getAge());
            s.setCourse(newdata.getCourse());
            s.setEmail(newdata.getEmail());
            s.setAdmissionDate(newdata.getAdmissionDate());
            s.setMobileNumber(newdata.getMobileNumber());
            s.setGender(newdata.getGender());
//            s.setMarks(newdata.getMarks());
            s.setFees(newdata.getFees());

            return repo.save(s);
        }
        return null;
    }

    @Override
    public String deleteStudent(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Student deleted successfully";
        }
        return "Student not found";
    }
}
