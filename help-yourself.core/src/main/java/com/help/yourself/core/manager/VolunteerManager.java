package com.help.yourself.core.manager;

import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.manager.IManager.IVolunteerManager;
import com.help.yourself.core.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class VolunteerManager implements IVolunteerManager, UserDetailsService {

    @Autowired
    private VolunteerRepository volunteerRepository;


    @Override
    public void create(Volunteer volunteer) {
        volunteer.setId();
        volunteerRepository.save(volunteer);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Volunteer user = volunteerRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
