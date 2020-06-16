package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.response.AirportResponse;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private EurekaClient eurekaClient;

    @Value("${airport_service}")
    private String airportServiceName;
    
    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }
    
	@Override
	public AirportResponse getByCode(String code) {
		return restTemplate.getForObject(lookupUrlFor(airportServiceName) + "/airports?code="+code, AirportResponse.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AirportResponse> getAll() {
		return restTemplate.getForObject(lookupUrlFor(airportServiceName) + "/airports", List.class);
	}

}
