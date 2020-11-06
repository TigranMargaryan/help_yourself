package com.help.yourself.web.Controller;

import com.help.yourself.common.resource.MessageStatus;
import com.help.yourself.common.resource.UserType;
import com.help.yourself.web.config.Response;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/help-yourself/messages/statuses")

public class MessageStatusController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public Response<Map<String, List<JSONObject>>> getMessageStatus() {
        List<JSONObject> status = new ArrayList<>();

        for(MessageStatus type : MessageStatus.values()) {
            status.add(type.toJSON());
        }

        return new Response<>(new HashMap<String, List<JSONObject>>() {{
            put("status", status);
        }});
    }
}
