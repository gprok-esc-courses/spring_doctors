package com.project.doctors.controller;

import com.project.doctors.model.User;
import com.project.doctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        String [] products = {"Keyboards", "Mice", "Monitors"};
        model.addAttribute("products", products);
        return "about";
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {
        List<User> doctors = userRepository.findByRole("DOCTOR");
        model.addAttribute("doctors", doctors);
        return "doctors";
    }

}
