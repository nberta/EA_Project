package edu.miu.cs544.aggregator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.aggregator.response.AirlineResponse;

@Service
public class AirlineServiceImpl implements AirlineService{
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
    
    public AirlineResponse getByCode(String code) {
		return restTemplate.getForObject(lookupUrlFor(airportServiceName) + "/airlines?code="+code, AirlineResponse.class);
	}
    
    @SuppressWarnings("unchecked")
	public List<AirlineResponse> getAll() {
        return restTemplate.getForObject(lookupUrlFor(airportServiceName) + "/airlines", List.class);
    }
	
	@SuppressWarnings("unchecked")
	public List<AirlineResponse> getAllByDepartureAirportCode(String departure_airport_code) {
		return restTemplate.getForObject(lookupUrlFor(airportServiceName) + "/airlines?departure_airport_code="+departure_airport_code, List.class);
	}
}
