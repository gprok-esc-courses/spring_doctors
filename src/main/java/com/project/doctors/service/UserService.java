package com.project.doctors.service;

import com.project.doctors.model.User;

public interface UserService {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
