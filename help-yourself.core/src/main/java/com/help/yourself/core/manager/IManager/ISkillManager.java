package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.Skill;
import javassist.bytecode.DuplicateMemberException;

public interface ISkillManager {
    Skill getById(String id);
    void create(UserContext userContext, Skill skill) throws DuplicateMemberException;
    Void update(Skill skill);
    void delete(Skill skill);
}
