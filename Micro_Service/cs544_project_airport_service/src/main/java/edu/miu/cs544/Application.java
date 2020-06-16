package edu.miu.cs544;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs544.domain.Address;
import edu.miu.cs544.domain.Airline;
import edu.miu.cs544.domain.Airport;
import edu.miu.cs544.domain.Flight;
import edu.miu.cs544.repository.FlightRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class Application implements CommandLineRunner {
	
	@Autowired
    private FlightRepository flightRepository;	
	
	private DateFormat dateFormat = new SimpleDateFormat("MM dd, yyyy hh:mm");
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/* Airline objects */
        Airline airline1 = new Airline("UA","United Airlines", "AAAAAAAAAAAAAAAAAA");
        Airline airline2 = new Airline("KAL","Korean Air", "AAAAAAAAAAAAAAAAAA");
        Airline airline3 = new Airline("OM","MIAT-MONGOLIAN AIRLINES", "AAAAAAAAAAAAAAAAAA");
        
        /* Address */
        Address address1 = new Address("1000N 4th str","Fairfield","IA","52557");
        Address address2 = new Address("1000N 4th str","Chicago","IL","52557");
        Address address3 = new Address("1000N 4th str","Chicago","IL","52556");

        /* Airport*/
        Airport cid = new Airport("CID", "Eastern Iowa Airport", address1);
        Airport ams = new Airport("AMS", "Schiphol", address2);
        Airport lhr = new Airport("LHR", "London Heathrow", address3);
        Airport fra = new Airport("FRA", "Frankfurt International Airport", address1);
        Airport dtw = new Airport("DTW", "Detroid City", address2);
        Airport ord = new Airport("ORD", "Chicago O'hare International", address3);
        Airport lax = new Airport("LAX", "Los Angeles International", address1);
        Airport jfk = new Airport("JFK", "John F. Kennedy International", address2);
        Airport nrt = new Airport("NRT", "Narita International Airport", address3);
        Airport syd = new Airport("SYD", "Kingsford Smith", address1);
        Airport sin = new Airport("SIN", "Changi Airport", address2);

        /* Flight */
        Flight flight1 = new Flight(1248, 500, airline1, cid, ord, dateFormat.parse("05 21, 2020 23:00"), dateFormat.parse("05 21, 2020 23:00"));
        Flight flight2 = new Flight(1249, 500, airline2, ams, lhr, dateFormat.parse("05 21, 2020 23:00"), dateFormat.parse("05 21, 2020 23:00"));
        Flight flight3 = new Flight(1250, 500, airline3, fra, dtw, dateFormat.parse("05 21, 2020 23:00"), dateFormat.parse("05 21, 2020 23:00"));
        Flight flight4 = new Flight(1251, 500, airline1, lax, syd, dateFormat.parse("05 21, 2020 23:00"), dateFormat.parse("05 21, 2020 23:00"));
        Flight flight5 = new Flight(1252, 500, airline2, jfk, syd, dateFormat.parse("05 21, 2020 23:00"), dateFormat.parse("05 21, 2020 23:00"));
        Flight flight6 = new Flight(1253, 500, airline3, nrt, sin, dateFormat.parse("05 21, 2020 23:00"), dateFormat.parse("05 21, 2020 23:00"));
 
        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6));
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
