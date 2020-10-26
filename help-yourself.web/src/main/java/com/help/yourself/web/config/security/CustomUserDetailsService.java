package com.help.yourself.web.config.security;

import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    VolunteerRepository volunteerRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Volunteer volunteer = volunteerRepository.findByEmail(email);
        if(volunteer == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new SecurityDetails(volunteer);
    }
}
