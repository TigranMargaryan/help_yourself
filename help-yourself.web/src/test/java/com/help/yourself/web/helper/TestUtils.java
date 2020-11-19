package com.help.yourself.web.helper;

import com.help.yourself.web.config.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class TestUtils {

    public static HttpEntity<Map<String, Object>> getAccessTokenBasedRequest(String accessToken) {
        return new HttpEntity<>(new HashMap<>(), getHeaders(accessToken));
    }

    private static MultiValueMap<String, String> getHeaders(String accessToken) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(TestConstants.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(TestConstants.AUTHORIZATION, TestConstants.BEARER + accessToken);

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

    public static Map<String, Map<String, Object>> getResponseDataAsMap(ResponseEntity<Response> response) {
        return (Map<String, Map<String, Object>>) response.getBody().getData();
    }
}
