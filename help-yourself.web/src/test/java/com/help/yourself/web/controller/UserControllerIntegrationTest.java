package com.help.yourself.web.controller;

import com.help.yourself.web.ApplicationTests;
import com.help.yourself.web.config.Response;
import com.help.yourself.web.helper.TestConstants;
import com.help.yourself.web.helper.TestHelper;
import com.help.yourself.web.helper.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

import java.util.Map;
import static com.help.yourself.web.helper.TestConstants.*;

public class UserControllerIntegrationTest extends ApplicationTests {

   private Map<String, Object> volunteer;
   private String userId;
   private String accessToken;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void setUp(){
       HttpEntity<?> request = new HttpEntity<Object>(TestHelper.addVolunteerRequest(getRequest()), null);
       TestHelper.addVolunteerRequest(getRequest());

        Response<Map<String, Map<String, Object>>> response = restTemplate.postForObject("/users", request, Response.class);

        Map<String, Object> createdUser = response.getData().get(USER);

        userId = (String) createdUser.get(ID);

        TestRestTemplate restTemplateWithBasicAuth = restTemplate.withBasicAuth(TestUtils.getClientId(), TestUtils.getClientSecret());
        Map<String, String> responseLogin = restTemplateWithBasicAuth.postForObject(TestConstants.LOGIN_URL, TestUtils.getLoginRequest(), Map.class);

        accessToken = responseLogin.get(ACCESS_TOKEN);
    }

    @Test
    public void getUser(){

    }
}
