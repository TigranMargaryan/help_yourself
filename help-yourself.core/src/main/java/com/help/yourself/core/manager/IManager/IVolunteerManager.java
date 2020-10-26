package com.help.yourself.core.manager.IManager;

import com.help.yourself.core.data.Volunteer;
import javassist.bytecode.DuplicateMemberException;

public interface IVolunteerManager {
    void create(Volunteer volunteer) throws DuplicateMemberException;
    Volunteer getByEmail(String email);
}
