package com.example.yashbhise.Controller;


import com.example.yashbhise.Model.Admission;
import com.example.yashbhise.Repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/admission")
@CrossOrigin("*")
public class AdmissionController {

    @Autowired
    private AdmissionRepository repo;


    @PostMapping
    public ResponseEntity<?> saveAdmission(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String mobile,
            @RequestParam String course,
            @RequestParam String college,
            @RequestParam String education,
            @RequestParam String passoutYear,
            @RequestParam String address,
            @RequestParam String utrNo,
            @RequestParam String qrToken
           // @RequestParam MultipartFile screenshot
    ) {
        try {
            Admission a = new Admission();
            a.setName(name);
            a.setEmail(email);
            a.setMobile(mobile);
            a.setCourse(course);
            a.setCollege(college);
            a.setEducation(education);
            a.setPassoutYear(passoutYear);
            a.setAddress(address);
            a.setUtrNo(utrNo);
            a.setQrToken(qrToken);
            a.setStatus("Pending");
         //   a.setScreenshot(screenshot.getBytes());

            repo.save(a);
            return ResponseEntity.ok("Admission saved successfully");

//        } catch (IOException e) {
//            return ResponseEntity.badRequest().body("Screenshot upload failed");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Server error");
        }
    }


//    @GetMapping("/pending")
//    public List<Map<String, Object>> pendingAdmissions() {
//
//        List<Admission> list = repo.findByStatus("Pending");
//        List<Map<String, Object>> response = new ArrayList<>();
//
//        for (Admission a : list) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("id", a.getId());
//            map.put("name", a.getName());
//            map.put("email", a.getEmail());
//            map.put("mobile", a.getMobile());
//            map.put("course", a.getCourse());
//            map.put("college", a.getCollege());
//            map.put("education", a.getEducation());
//            map.put("passoutYear", a.getPassoutYear());
//            map.put("utrNo", a.getUtrNo());
//            map.put("status", a.getStatus());
//
//
//            map.put("screenshot", Base64.getEncoder().encodeToString(a.getScreenshot()));
//
//            response.add(map);
//        }
//        return response;
//    }
@GetMapping("/pending")
public List<Map<String, Object>> pendingAdmissions() {

    List<Admission> list = repo.findByStatus("Pending");
    List<Map<String, Object>> response = new ArrayList<>();

    for (Admission a : list) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", a.getId());
        map.put("name", a.getName());
        map.put("email", a.getEmail());
        map.put("mobile", a.getMobile());
        map.put("course", a.getCourse());
        map.put("college", a.getCollege());
        map.put("education", a.getEducation());
        map.put("passoutYear", a.getPassoutYear());
        map.put("utrNo", a.getUtrNo());
        map.put("status", a.getStatus());


//        if (a.getScreenshot() != null && a.getScreenshot().length > 0) {
//            map.put(
//                    "screenshot",
//                    Base64.getEncoder().encodeToString(a.getScreenshot())
//            );
//        } else {
//            map.put("screenshot", null);
//        }

        response.add(map);
    }
    return response;
}


    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        Optional<Admission> opt = repo.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Admission a = opt.get();
        a.setStatus(status);
        repo.save(a);
        return ResponseEntity.ok("Status updated");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}