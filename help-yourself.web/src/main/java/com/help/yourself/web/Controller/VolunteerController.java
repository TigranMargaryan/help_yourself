package com.help.yourself.web.Controller;

import com.help.yourself.common.resource.VolunteerResource;
import com.help.yourself.core.context.VolunteerContext;
import com.help.yourself.core.data.Volunteer;
import com.help.yourself.core.manager.IManager.IVolunteerManager;
import com.help.yourself.core.repository.VolunteerRepository;
import com.help.yourself.web.config.Response;
import javassist.bytecode.DuplicateMemberException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class VolunteerController {

    IVolunteerManager volunteerManager;

    @Autowired
    VolunteerRepository volunteerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public VolunteerController(IVolunteerManager volunteerManager){
        this.volunteerManager = volunteerManager;
    }

    @GetMapping(value = "/help-yourself/volunteer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getVolunteer(@AuthenticationPrincipal VolunteerContext volunteerContext){
        Volunteer volunteer = volunteerManager.getByEmail(volunteerContext.getVolunteerEmail());

        VolunteerResource resource = modelMapper.map(volunteer, VolunteerResource.class);

        return new Response<>(new HashMap<String, VolunteerResource>(){{
            put("volunteer", resource);
        }
        });
    }

    @PostMapping(value = "/volunteer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createVolunteer(@RequestBody VolunteerResource volunteerResource) throws DuplicateMemberException {
        Volunteer volunteer = modelMapper.map(volunteerResource, Volunteer.class);

        volunteerManager.create(volunteer);

        VolunteerResource resource = modelMapper.map(volunteer, VolunteerResource.class);

        return new Response<>(new HashMap<String, VolunteerResource>() {{
            put("volunteer", resource);
        }});
    }
}
