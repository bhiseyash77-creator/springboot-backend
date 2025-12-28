package com.example.yashbhise.Controller;

import com.example.yashbhise.Model.Inquiry;
import com.example.yashbhise.Repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class InquiryController {

    @Autowired
    private InquiryRepository repo;

    // Add Inquiry
    @PostMapping("/inquiry")
    public Inquiry addInquiry(@RequestBody Inquiry inquiry) {
        inquiry.setStatus("Pending");
        return repo.save(inquiry);
    }

    // Get Pending Inquiries
    @GetMapping("/inquiries/pending")
    public List<Inquiry> getPending() {
        return repo.findByStatus("Pending");
    }

    // Update Inquiry to Complete
    @PutMapping("/inquiry/{id}/complete")
    public Inquiry completeInquiry(@PathVariable int id) {
        Inquiry i = repo.findById(id).orElseThrow();
        i.setStatus("Complete");
        return repo.save(i);
    }
}

