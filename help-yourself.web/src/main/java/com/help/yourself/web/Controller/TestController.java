package com.help.yourself.web.Controller;

import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.manager.IManager.IVolunteerManager;
import com.help.yourself.core.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    IVolunteerManager volunteerManager;

    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName("tiko");
        volunteer.setLastName("marga");
        volunteer.setUserName("tlam");
        volunteer.setMail("gmail");
        volunteer.setPassword("password");
        volunteer.setId("1");
        volunteerRepository.save(volunteer);

        //volunteerManager.create(volunteer);
        return "this is a test call";
    }
}
