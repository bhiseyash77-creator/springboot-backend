package com.example.yashbhise.Controller;


import com.example.yashbhise.Model.Admission;
import com.example.yashbhise.Repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admission")
public class AdmissionController {

    @Autowired
    private AdmissionRepository admissionRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<String> submitAdmission(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String mobile,
            @RequestParam String qrToken,
            @RequestParam MultipartFile screenshot) throws IOException {

        Admission admission = new Admission();
        admission.setName(name);
        admission.setEmail(email);
        admission.setMobile(mobile);
//        admission.setToken(qrToken);
        admission.setQrToken(qrToken);
        admission.setStatus("Pending");
        admission.setScreenshot(screenshot.getBytes());

        admissionRepository.save(admission);
        return ResponseEntity.ok("Admission saved successfully!");
    }

    // READ ALL
    @GetMapping
    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    // READ SINGLE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Admission> getAdmission(@PathVariable Long id) {
        Optional<Admission> admission = admissionRepository.findById(id);
        return admission.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmission(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String mobile,
            @RequestParam String status,
            @RequestParam(required = false) MultipartFile screenshot) throws IOException {

        Optional<Admission> optional = admissionRepository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Admission admission = optional.get();
        admission.setName(name);
        admission.setEmail(email);
        admission.setMobile(mobile);
        admission.setStatus(status);
        if (screenshot != null) {
            admission.setScreenshot(screenshot.getBytes());
        }

        admissionRepository.save(admission);
        return ResponseEntity.ok("Admission updated successfully!");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmission(@PathVariable Long id) {
        if (!admissionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        admissionRepository.deleteById(id);
        return ResponseEntity.ok("Admission deleted successfully!");
    }

    // GET PENDING ADMISSIONS
    @GetMapping("/pending")
    public List<Admission> getPendingAdmissions() {
        return admissionRepository.findByStatus("Pending");
    }
}
