package com.help.yourself.web.Controller;

import com.help.yourself.common.resource.SkillResource;
import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.Skill;
import com.help.yourself.core.manager.IManager.ISkillManager;
import com.help.yourself.web.config.Response;
import javassist.bytecode.DuplicateMemberException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SkillController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ISkillManager skillManager;

    @PostMapping(value = "/help-yourself/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createSkill(@RequestBody SkillResource skillResource, @AuthenticationPrincipal UserContext userContext) throws DuplicateMemberException {
        Skill skill = modelMapper.map(skillResource, Skill.class);

        skillManager.create(userContext, skill);

        SkillResource createdSkillResource = modelMapper.map(skill, SkillResource.class);

        return new Response<>(new HashMap<String, SkillResource>() {{
            put("skill", createdSkillResource);
        }});
    }
}
