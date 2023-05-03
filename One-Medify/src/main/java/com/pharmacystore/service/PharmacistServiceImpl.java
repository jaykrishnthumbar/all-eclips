package com.pharmacystore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacystore.controller.Pharmacist;
import com.pharmacystore.dto.PharmacistDto;
import com.pharmacystore.exception.ResourceNotFound;
import com.pharmacystore.repo.PharmacistRepo;

@Service
public class PharmacistServiceImpl implements PharmacistService {

	@Autowired
	private PharmacistRepo pharmacistrepo;

	@Autowired
	public ModelMapper modelMapper;

	@Override
	public PharmacistDto pharmacistToPharmacistDto(Pharmacist pharmacist) {

		PharmacistDto pharmacistdto = this.modelMapper.map(pharmacist, PharmacistDto.class);

//		PharmacistDto ph = new PharmacistDto();
//		ph.setName(pharmacist.getName());
//		ph.setEmail(pharmacist.getEmail());
//		ph.setPassword(pharmacist.getPassword());
//		ph.setDate(pharmacist.getDate());
//		ph.setMobile(pharmacist.getMobile());
//		ph.setAddress(pharmacist.getAddress());
//		ph.setState(pharmacist.getState());
//		ph.setCity(pharmacist.getCity());

		return pharmacistdto;
	}

	@Override
	public Pharmacist pharmacistDtoToPharmacist(PharmacistDto pharmacistdto) {

		Pharmacist pharmacist = this.modelMapper.map(pharmacistdto, Pharmacist.class);

//		Pharmacist ph = new Pharmacist();
//		ph.setName(pharmacistdto.getName());
//		ph.setEmail(pharmacistdto.getEmail());
//		ph.setPassword(pharmacistdto.getPassword());
//		ph.setDate(pharmacistdto.getDate());
//		ph.setMobile(pharmacistdto.getMobile());
//		ph.setAddress(pharmacistdto.getAddress());
//		ph.setState(pharmacistdto.getState());
//		ph.setCity(pharmacistdto.getCity());

		return pharmacist;
	}

	@Override
	public String savePharmacist(PharmacistDto pharmacistdto) {

		Pharmacist pharmacist = pharmacistDtoToPharmacist(pharmacistdto);
		pharmacistrepo.save(pharmacist);
		return "Saved Successfully...";
	}

	@Override
	public List<PharmacistDto> getAllPharmacist(PharmacistDto pharmacistdto) {
		return pharmacistrepo.findAll().stream().map(getAllPharmacist -> pharmacistToPharmacistDto(getAllPharmacist))
				.collect(Collectors.toList());
	}

	@Override
	public PharmacistDto getPharmacist(int id) {
		return pharmacistToPharmacistDto(
				pharmacistrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User does not exist..")));
	}

	@Override
	public String deletePharmacist(int id) {
		Pharmacist ph = pharmacistrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User does not exist.."));
		pharmacistrepo.delete(ph);
		return "Delete successfully...";
	}

	@Override
	public String updatePharmacist(PharmacistDto pharmacistdto, int id) {
		Pharmacist ph = pharmacistrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User does not exist.."));

		ph.setName(pharmacistdto.getName());
		ph.setEmail(pharmacistdto.getEmail());
		ph.setPassword(pharmacistdto.getPassword());
		ph.setDate(pharmacistdto.getDate());
		ph.setMobile(pharmacistdto.getMobile());
		ph.setAddress(pharmacistdto.getAddress());
		ph.setState(pharmacistdto.getState());
		ph.setCity(pharmacistdto.getCity());
		pharmacistrepo.save(ph);
		return "Updated Successfully....";
	}

	@Override
	public PharmacistDto getPharmacyByEmail(String email) {
		return pharmacistToPharmacistDto(
				pharmacistrepo.findByEmail(email).orElseThrow(() -> new ResourceNotFound("User does not exist...")));
	}

	@Override
	public List<PharmacistDto> findPharmacyByName(String name) {
		// TODO Auto-generated method stub
		return pharmacistrepo.findByName(name).stream().map(p -> pharmacistToPharmacistDto(p))
				.collect(Collectors.toList());
	}

	@Override
	public List<PharmacistDto> findByCityAndState(String city, String state) {
		return pharmacistrepo.findByCityAndState(city, state).stream().map(p -> pharmacistToPharmacistDto(p))
				.collect(Collectors.toList());
	}

	@Override
	public PharmacistDto getByMobile(Long mobile) {
		return pharmacistToPharmacistDto(
				pharmacistrepo.getByMobile(mobile).orElseThrow(() -> new ResourceNotFound("User does not exist...")));
	}

}
