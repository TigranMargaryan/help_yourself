package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.data.User;
import javassist.bytecode.DuplicateMemberException;

public interface IUserManager {
    User getById(String id);

    void create(User user) throws DuplicateMemberException;

    void update(User user);

    void delete(User user);
}
