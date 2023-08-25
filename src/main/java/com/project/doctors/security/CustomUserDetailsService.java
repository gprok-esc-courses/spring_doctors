package com.project.doctors.security;

import com.project.doctors.model.User;
import com.project.doctors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRole())
            );
        }
        else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        Collection<String> roles = new ArrayList<>();
        roles.add(role);
        Collection<? extends  GrantedAuthority> authorities = roles.stream()
                .map(r -> new SimpleGrantedAuthority(r))
                .collect(Collectors.toList());

        return authorities;
    }
}
