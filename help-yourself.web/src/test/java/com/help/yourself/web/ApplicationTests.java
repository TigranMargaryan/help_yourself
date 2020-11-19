package com.help.yourself.web;

import com.help.yourself.web.helper.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ApplicationTests {

	public HttpEntity<Map<String, Object>> getRequest() {
		return TestUtils.getAccessTokenBasedRequest();
	}

}
