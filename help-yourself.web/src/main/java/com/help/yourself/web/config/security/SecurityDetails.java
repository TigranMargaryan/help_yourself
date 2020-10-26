package com.help.yourself.web.config.security;

import com.help.yourself.core.context.VolunteerContext;
import com.help.yourself.core.data.Volunteer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class SecurityDetails implements VolunteerContext, UserDetails {

    private String id;
    private String email;
    private String username;
    private String password;

    public SecurityDetails(Volunteer volunteer){
        this.id = volunteer.getId();
        this.email = volunteer.getEmail();
        this.username = volunteer.getUserName();
        this.password = volunteer.getPassword();
    }

    @Override
    public String getVolunteerId() {
        return id;
    }

    @Override
    public String getVolunteerEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
