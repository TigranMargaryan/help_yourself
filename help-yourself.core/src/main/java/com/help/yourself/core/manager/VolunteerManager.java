package com.help.yourself.core.manager;

import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.manager.IManager.IVolunteerManager;
import com.help.yourself.core.repository.VolunteerRepository;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerManager implements IVolunteerManager {

    @Autowired
    private VolunteerRepository volunteerRepository;



    @Override
    public void create(Volunteer volunteer) throws DuplicateMemberException {
        Volunteer user = volunteerRepository.findByEmail(volunteer.getEmail());

        if (user != null){
            throw new DuplicateMemberException("volunteer with this email already exist");
        }

        volunteer.setId();
        volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer getByEmail(String email) {
        Volunteer volunteer = volunteerRepository.findByEmail(email);

        if(volunteer == null){
            throw new NullPointerException("volunteer with this email don't exist");
        }
        return volunteer;
    }
}
