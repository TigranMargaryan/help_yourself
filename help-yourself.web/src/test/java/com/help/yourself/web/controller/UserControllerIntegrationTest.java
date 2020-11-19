package com.help.yourself.web.controller;

import com.help.yourself.web.ApplicationTests;
import com.help.yourself.web.config.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import static com.help.yourself.web.helper.TestConstants.*;
import static com.help.yourself.web.helper.TestUtils.*;

public class UserControllerIntegrationTest extends ApplicationTests {

    @Autowired
    protected TestRestTemplate restTemplate;


    @Test
    public void getUser(){

        HttpEntity<Map<String, Object>> request = getRequest();

        ResponseEntity<Response> response = restTemplate.exchange("/help-yourself/users", HttpMethod.GET, getRequest(), Response.class);

        Map<String, Object> user = getResponseDataAsMap(response).get(USER);

        Assert.assertNotNull(user.get(ID));
        Assert.assertNotNull(user.get(FIRST_NAME));
        Assert.assertNotNull(user.get(LAST_NAME));
        Assert.assertNotNull(user.get(USERNAME));
        Assert.assertNotNull(user.get(EMAIL));
    }
}
