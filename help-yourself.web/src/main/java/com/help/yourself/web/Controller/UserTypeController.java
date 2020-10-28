package com.help.yourself.web.Controller;

import com.help.yourself.common.resource.UserType;
import com.help.yourself.core.context.UserContext;
import com.help.yourself.web.config.Response;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/help-yourself/users/types")
public class UserTypeController {
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public Response<Map<String, List<JSONObject>>> getContactTypes() {
        List<JSONObject> types = new ArrayList<>();

        for(UserType type : UserType.values()) {
            types.add(type.toJSON());
        }

        return new Response<>(new HashMap<String, List<JSONObject>>() {{
            put("types", types);
        }});
    }
}
