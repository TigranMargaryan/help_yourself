package com.help.yourself.core.manager;

import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.UserSkill;
import com.help.yourself.core.manager.IManager.IUserSkillManager;
import com.help.yourself.core.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillManger implements IUserSkillManager {

    @Autowired
    UserSkillRepository userSkillRepository;

    @Override
    public UserSkill getById(UserContext userContext, String id) {
        return null;
    }

    @Override
    public void create(UserContext userContext, UserSkill userSkill) {
        userSkillRepository.save(userSkill);
    }

    @Override
    public void Update(UserContext userContext, String id) {

    }

    @Override
    public void delete(UserContext userContext, String id) {

    }
}
