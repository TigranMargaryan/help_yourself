package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.UserSkill;

public interface IUserSkillManager {
    UserSkill getById(UserContext userContext, String id);

    void create(UserContext userContext, UserSkill userSkill);

    void Update(UserContext userContext, String id);

    void delete(UserContext userContext, UserSkill userSkill);
}
