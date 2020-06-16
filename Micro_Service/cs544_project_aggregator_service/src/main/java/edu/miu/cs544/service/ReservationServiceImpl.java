package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.response.ReservationResponse;

@Service
public class ReservationServiceImpl implements ReservationService {

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
	public ReservationResponse getByCode(String code) {
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/reservations?code="+code, ReservationResponse.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationResponse> getAll() {
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/reservations", List.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationResponse> getAllByPassengerId(Integer passenger_id) {
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/reservations?passenger_id="+passenger_id, List.class);
	}

}
