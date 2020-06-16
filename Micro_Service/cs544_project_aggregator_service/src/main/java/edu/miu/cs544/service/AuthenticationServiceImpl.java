package edu.miu.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.response.UserResponse;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

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
    
	@SuppressWarnings("rawtypes")
	@Override
	public UserResponse validateTokenGet(String token) {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.set("Authorization", "Bearer "+token);
		HttpEntity requestEntity = new HttpEntity<>(httpHeader);
		
		return restTemplate.exchange(lookupUrlFor(authServiceName) + "/validate", HttpMethod.GET, requestEntity, UserResponse.class).getBody();
	}
	
	@Override
	public UserResponse validateTokenPost(String token) {
		HttpEntity<String> request = new HttpEntity<String>(token);
			     
		return restTemplate.postForEntity(lookupUrlFor(authServiceName) + "/validate", request, UserResponse.class).getBody();
	}
}
