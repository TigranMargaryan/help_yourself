package com.help.yourself.web.Controller;

import com.help.yourself.common.resource.UserProfileResource;
import com.help.yourself.common.resource.UserResource;
import com.help.yourself.core.context.UserContext;
import com.help.yourself.core.data.User;
import com.help.yourself.core.manager.IManager.IUserManager;
import com.help.yourself.core.repository.UserRepository;
import com.help.yourself.web.config.Response;
import javassist.bytecode.DuplicateMemberException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    IUserManager userManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public UserController(IUserManager userManager){
        this.userManager = userManager;
    }

    @GetMapping(value = "/help-yourself/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUser(@AuthenticationPrincipal UserContext userContext){
        User user = userManager.getById(userContext.getId());

        UserProfileResource resource = modelMapper.map(user, UserProfileResource.class);

        return new Response<>(new HashMap<String, UserProfileResource>(){{
            put("user", resource);
        }
        });
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createUser(@RequestBody UserResource userResource) throws DuplicateMemberException {
        User user = modelMapper.map(userResource, User.class);

        userManager.create(user);

        UserResource resource = modelMapper.map(user, UserResource.class);

        return new Response<>(new HashMap<String, UserResource>() {{
            put("user", resource);
        }});
    }

    @PutMapping(value = "/help-yourself/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateUser(@RequestBody UserProfileResource userResource, @AuthenticationPrincipal UserContext userContext){
        User user = userManager.getById(userContext.getId());

        modelMapper.map(userResource, user);

        userManager.update(user);

        UserProfileResource resource = modelMapper.map(user, UserProfileResource.class);

        return new Response(new HashMap<String, UserProfileResource>(){{
            put("user", resource);
        }});
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/help-yourself/users")
    public Response deleteUser(@AuthenticationPrincipal UserContext userContext){
        User user = userManager.getById(userContext.getId());

        userManager.delete(user);

        return new Response("Accepted");
    }
}
