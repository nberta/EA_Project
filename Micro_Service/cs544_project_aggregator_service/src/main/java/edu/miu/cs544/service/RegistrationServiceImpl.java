package edu.miu.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.request.UserRequest;
import edu.miu.cs544.service.response.UserResponse;
import edu.miu.cs544.util.Constant.ERole;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private EurekaClient eurekaClient;

    @Value("${auth_service}")
    private String authServiceName;
    
    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }
    
	@Override
	public UserResponse saveUser(String token, UserRequest userRequest, ERole roleType) {
		String url = "";
		switch (roleType) {
			case ROLE_ADMIN:
				url = "/admin";
				break;
			case ROLE_AGENT:
				url = "/agent";
				break;
			case ROLE_PASSENGER:
				url = "/passenger";
				break;
		}
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.set("Authorization", "Bearer "+token);
		HttpEntity requestEntity = new HttpEntity<>(userRequest,httpHeader);
		
		return restTemplate.postForEntity(lookupUrlFor(authServiceName) + url, requestEntity, UserResponse.class).getBody();
	}

}
