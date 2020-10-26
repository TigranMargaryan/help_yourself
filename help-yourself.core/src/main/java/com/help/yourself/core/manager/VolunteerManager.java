package com.help.yourself.core.manager;

import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.manager.IManager.IVolunteerManager;
import com.help.yourself.core.repository.VolunteerRepository;
import javassist.bytecode.DuplicateMemberException;
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
    public void create(Volunteer volunteer) throws DuplicateMemberException {
        Volunteer user = volunteerRepository.findByEmail(volunteer.getEmail());

        if (user != null){
            throw new DuplicateMemberException("volunteer with this email already exist");
        }

        volunteer.setId();
        volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer getByEmail(String email) {
        Volunteer volunteer = volunteerRepository.findByEmail(email);

        if(volunteer == null){
            throw new NullPointerException("volunteer with this email don't exist");
        }
        return volunteer;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Volunteer user = volunteerRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
