package com.help.yourself.core.repository;

import com.help.yourself.core.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String id);
    User findByEmail(String email);
}
