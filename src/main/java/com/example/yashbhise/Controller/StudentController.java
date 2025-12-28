package com.example.yashbhise.Controller;

import com.example.yashbhise.Model.Student;
import com.example.yashbhise.ServiceImp.StudentImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:5173/")
@RequestMapping("/student")

public class StudentController {

    @Autowired
    StudentImp ser;

    @PostMapping
    public Student addStudent(@RequestBody Student s){
        return ser.addStudent(s);

    }
    @GetMapping
    public List<Student> getAllStudent(){
        return ser.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return ser.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student s){
        return ser.updateStudent(id,s);
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return ser.deleteStudent(id);
    }
}
