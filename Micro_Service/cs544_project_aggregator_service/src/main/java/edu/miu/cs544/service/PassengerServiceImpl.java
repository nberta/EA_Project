package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.response.PassengerResponse;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private EurekaClient eurekaClient;

    @Value("${reservation_service}")
    private String reservationServiceName;
    
    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }
    
	@Override
	public PassengerResponse getById(Integer id) {
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/passengers?id="+id, PassengerResponse.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PassengerResponse> getAll() {
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/passengers", List.class);
	}

}
