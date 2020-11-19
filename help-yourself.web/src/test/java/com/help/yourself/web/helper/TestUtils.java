package com.help.yourself.web.helper;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class TestUtils {

    public static HttpEntity<Map<String, Object>> getAccessTokenBasedRequest() {
        return new HttpEntity<>(new HashMap<>(), getHeaders());
    }

    private static MultiValueMap<String, String> getHeaders() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(TestConstants.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        //headers.add(TestConstants.AUTHORIZATION, TestConstants.BEARER + accessToken);

        return headers;
    }

    public static String getClientId() {
        return TestConstants.CLIENT_ID;
    }

    public static String getClientSecret() {
        return TestConstants.CLIENT_SECRET;
    }

    public static MultiValueMap<String, String> getLoginRequest() {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add(TestConstants.PASSWORD, TestConstants.USER_PASSWORD);
        request.add(TestConstants.USER_NAME, TestConstants.USER_EMAIL);
        request.add(TestConstants.GRANT_TYPE, TestConstants.PASSWORD);

        return request;
    }
}
