package com.help.yourself.web.helper;

import org.springframework.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.help.yourself.web.helper.TestConstants.*;

@SuppressWarnings("unchecked")
public class TestHelper {

    public static Map<String, Object> addVolunteerRequest(HttpEntity<Map<String, Object>> request) {
        request.getBody().clear();


        String id = UUID.randomUUID().toString();
        String fistName = "firstName";
        String lastName = "lastName";
        String userName = "userName";
        String email = "testemail@gmail.com";
        String password = "123abc+";
        Integer type = 2;

        Map<String, Object> volunteer = new HashMap<>();
        volunteer.put(ID, id);
        volunteer.put(FIRST_NAME, fistName);
        volunteer.put(LAST_NAME, lastName);
        volunteer.put(USERNAME, userName);
        volunteer.put(PASSWORD, password);
        volunteer.put(EMAIL, email);
        volunteer.put(TYPE, type);

        return volunteer;
    }
}
