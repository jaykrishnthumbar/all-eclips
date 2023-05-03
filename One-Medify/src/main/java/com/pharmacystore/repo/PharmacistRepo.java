package com.pharmacystore.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pharmacystore.controller.Pharmacist;

@Repository
public interface PharmacistRepo extends JpaRepository<Pharmacist, Integer> {

	public List<Pharmacist> findByName(String name);

	@Query("SELECT u FROM Pharmacist u WHERE u.email=:email")
	public Optional<Pharmacist> findByEmail(@Param("email") String email);

	@Query("SELECT u FROM Pharmacist u WHERE u.city=:city and u.state=:state")
	public List<Pharmacist> findByCityAndState(@Param("city") String city, @Param("state") String state);

	public Optional<Pharmacist> getByMobile(Long mobile);
}
