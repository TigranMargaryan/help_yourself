package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.data.Volunteer;
import javassist.bytecode.DuplicateMemberException;

public interface IVolunteerManager {
    Volunteer getByEmail(String email);

    void create(Volunteer volunteer) throws DuplicateMemberException;

    void update(Volunteer volunteer);

    void delete(Volunteer volunteer);
}
