package com.help.yourself.core.repository;

import com.help.yourself.core.data.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
    List<UserSkill> findAllByUserId(String userId);
    UserSkill findFirstById(String id);
}
