package com.help.yourself.core.repository;

import com.help.yourself.core.data.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{
    Skill findByName(String name);
    Skill findFirstById(String id);
}
