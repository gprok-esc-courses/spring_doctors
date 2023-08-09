package com.project.doctors.repository;

import com.project.doctors.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySpecialty(String specialty);
    List<User> findByRole(String role);
}
