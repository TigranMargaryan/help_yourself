package com.help.yourself.web.Controller;

import com.help.yourself.common.resource.SkillResource;
import com.help.yourself.common.resource.UserSkillResource;
import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.Skill;
import com.help.yourself.core.data.User;
import com.help.yourself.core.data.UserSkill;
import com.help.yourself.core.manager.IManager.IUserManager;
import com.help.yourself.core.manager.IManager.IUserSkillManager;
import com.help.yourself.web.config.Response;
import javassist.bytecode.DuplicateMemberException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Transactional
public class UserSkillController {

    @Autowired
    IUserSkillManager userSkillManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUserManager userManager;

    @PostMapping(value = "/help-yourself/users/{userId}/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createSkill(@PathVariable("userId") String userId, @RequestBody UserSkillResource skillResource, @AuthenticationPrincipal UserContext userContext) throws DuplicateMemberException {

        UserSkill userSkill = modelMapper.map(skillResource, UserSkill.class);

        User user = userManager.getById(userId);
        boolean isSkillAttached = user.getUserSkills().stream().anyMatch(us -> us.getSkill().getId().equals(userSkill.getSkill().getId()));

        if (isSkillAttached) {
            throw new DuplicateMemberException("skill.duplicate");
        }

        userSkill.setUser(user);

        userSkillManager.create(userContext, userSkill);

        UserSkillResource updatedUserSkillResource = modelMapper.map(userSkill, UserSkillResource.class);

        return new Response<>(new HashMap<String, UserSkillResource>() {{
            put("userSkill", updatedUserSkillResource);
        }});
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/help-yourself/users/{userId}/skills/{skillId}")
    public Response deleteUser(@PathVariable String userId, @PathVariable String skillId, @AuthenticationPrincipal UserContext userContext){
        UserSkill userSkill = userSkillManager.getById(userContext, skillId);

        userSkillManager.delete(userContext, userSkill);

        return new Response("Accepted");
    }

}
