package com.project.doctors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @GetMapping("/doctor/dashboard")
    public String dashboard() {
        return "doctor/dashboard";
    }
}
