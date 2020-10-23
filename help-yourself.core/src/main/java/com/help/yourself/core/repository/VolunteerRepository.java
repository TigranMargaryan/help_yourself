package com.help.yourself.core.repository;

import com.help.yourself.core.data.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Volunteer findByUserName(String username);
}
