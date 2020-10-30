package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.Skill;
import com.help.yourself.core.repository.SkillRepository;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SKillManager implements ISkillManager {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public Skill getById(String id) {
        return null;
    }

    @Override
    public void create(UserContext userContext, Skill skill) throws DuplicateMemberException {

        Skill existSkill = skillRepository.findByName(skill.getName());

        if(existSkill != null){
            throw new DuplicateMemberException("Skill with this name already exist");
        }

        skill.setId();

        skillRepository.save(skill);
    }

    @Override
    public Void update(Skill skill) {
        return null;
    }

    @Override
    public void delete(Skill skill) {

    }
}
