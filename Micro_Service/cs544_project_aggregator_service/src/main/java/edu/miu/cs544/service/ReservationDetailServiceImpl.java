package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import edu.miu.cs544.service.response.ReservationDetailResponse;

@Service
public class ReservationDetailServiceImpl implements ReservationDetailService {

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
    
	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationDetailResponse> getAll() {
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/reservationDetails", List.class);
	}

	@Override
	public ReservationDetailResponse[] getAllByReservationCode(String reservation_code) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(lookupUrlFor(reservationServiceName) + "/reservationDetails?reservation_code="+reservation_code, ReservationDetailResponse[].class);
	}

}
