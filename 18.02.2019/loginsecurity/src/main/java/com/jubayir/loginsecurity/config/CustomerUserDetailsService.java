package com.jubayir.loginsecurity.config;

import com.jubayir.loginsecurity.entity.User;
import com.jubayir.loginsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByUserNameOrEmail(s, s);
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
