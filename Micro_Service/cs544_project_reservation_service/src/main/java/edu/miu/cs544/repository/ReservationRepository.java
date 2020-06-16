package edu.miu.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	Reservation findByCode(String code);
	List<Reservation> findByPassengerId(Integer id);
	List<Reservation> findByUserEmailAndPassengerId(String userEmail, Integer passengerId);
	List<Reservation> findByUserEmail(String userEmail);
}
