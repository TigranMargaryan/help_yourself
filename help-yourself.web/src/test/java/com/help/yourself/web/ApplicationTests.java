package com.help.yourself.web;

import com.help.yourself.core.data.User;
import com.help.yourself.core.repository.UserRepository;
import com.help.yourself.web.config.Response;
import com.help.yourself.web.helper.TestConstants;
import com.help.yourself.web.helper.TestHelper;
import com.help.yourself.web.helper.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static com.help.yourself.web.helper.TestConstants.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ApplicationTests {

	private boolean setUp;

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected TestRestTemplate restTemplate;

	protected User user;

	protected String userId;
	protected String accessToken;

	@Before
	public void setUpBase(){
		if(!setUp){
			HttpEntity<?> request = new HttpEntity<Object>(TestHelper.addVolunteerRequest(getRequest()), null);
			TestHelper.addVolunteerRequest(getRequest());

			Response<Map<String, Map<String, Object>>> response = restTemplate.postForObject("/users", request, Response.class);

			Map<String, Object> createdUser = response.getData().get(USER);

			userId = (String) createdUser.get(ID);

			TestRestTemplate restTemplateWithBasicAuth = restTemplate.withBasicAuth(TestUtils.getClientId(), TestUtils.getClientSecret());
			Map<String, String> responseLogin = restTemplateWithBasicAuth.postForObject(TestConstants.LOGIN_URL, TestUtils.getLoginRequest(), Map.class);

			accessToken = responseLogin.get(ACCESS_TOKEN);
			setUp = true;
		}
	}

	@After
	public void downBase(){
		if (userId != null){
			//userRepository.forceDeleteUser(userId);
		}
	}

	public HttpEntity<Map<String, Object>> getRequest() {
		return TestUtils.getAccessTokenBasedRequest(accessToken);
	}
}
