package com.jubayir.templateadding.configuration;

import com.jubayir.templateadding.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails(final User user){
        super(user);
    }
}
