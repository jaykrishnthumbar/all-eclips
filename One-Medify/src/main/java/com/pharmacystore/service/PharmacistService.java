package com.pharmacystore.service;

import java.util.List;
import com.pharmacystore.controller.Pharmacist;
import com.pharmacystore.dto.PharmacistDto;

public interface PharmacistService {
	public String savePharmacist(PharmacistDto pharmacistdto);

	public List<PharmacistDto> getAllPharmacist(PharmacistDto pharmacistdto);

	public PharmacistDto getPharmacist(int id);

	public String deletePharmacist(int id);

	public String updatePharmacist(PharmacistDto pharmacistdto, int id);

	PharmacistDto pharmacistToPharmacistDto(Pharmacist pharmacist);

	Pharmacist pharmacistDtoToPharmacist(PharmacistDto pharmacistdto);

	public PharmacistDto getPharmacyByEmail(String email);

	public List<PharmacistDto> findPharmacyByName(String name);

	public List<PharmacistDto> findByCityAndState(String city, String state);

	public PharmacistDto getByMobile(Long mobile);

}
