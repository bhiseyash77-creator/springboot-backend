package com.example.yashbhise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "admission")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String mobile;

    private String course;
    private String college;
    private String education;
    private String passoutYear;
    private String address;
    private String utrNo;

    private String status;
    private String qrToken;

//    @Lob
//     @Column(columnDefinition = "BYTEA")
//    @JsonIgnore
//    private byte[] screenshot;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPassoutYear() {
        return passoutYear;
    }

    public void setPassoutYear(String passoutYear) {
        this.passoutYear = passoutYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUtrNo() {
        return utrNo;
    }

    public void setUtrNo(String utrNo) {
        this.utrNo = utrNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrToken() {
        return qrToken;
    }

    public void setQrToken(String qrToken) {
        this.qrToken = qrToken;
    }

//    public byte[] getScreenshot() {
//        return screenshot;
//    }
//
//    public void setScreenshot(byte[] screenshot) {
//        this.screenshot = screenshot;
//    }
}