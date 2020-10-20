package com.help.yourself.core.manager;

import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.manager.IManager.IVolunteerManager;
import com.help.yourself.core.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerManager implements IVolunteerManager {

    @Autowired
    private VolunteerRepository volunteerRepository;


    @Override
    public void create(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }
}
