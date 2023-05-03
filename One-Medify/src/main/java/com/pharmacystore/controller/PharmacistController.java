package com.pharmacystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pharmacystore.dto.PharmacistDto;
import com.pharmacystore.service.PharmacistService;

@RestController
@RequestMapping("/welcome")
public class PharmacistController {
	
	@Autowired
	private PharmacistService pharmacisrservice;
	
	@PostMapping("/savepharmacist")
	public String savePharmacist(@RequestBody PharmacistDto pharmacistdto) {
		return pharmacisrservice.savePharmacist(pharmacistdto);

	}
	
	@GetMapping("/getallpharmacist")
	public List<PharmacistDto> getAllPharmacist(PharmacistDto pharmacistdto) {
		return pharmacisrservice.getAllPharmacist(pharmacistdto);

	}
	
	@GetMapping("/getpharmacistbyid/{id}")
	public PharmacistDto getPharmacist(@PathVariable int id) {
		return pharmacisrservice.getPharmacist(id);
		
	}
	
	@DeleteMapping("/deletepharmacistbyid/{id}")
	public String deletePharmacist(@PathVariable int id) {
		return pharmacisrservice.deletePharmacist(id);
	}
	
	@PutMapping("/updatepharmacistbyid/{id}")
	public String updatePharmacist(@RequestBody PharmacistDto pharmacistdto,@PathVariable int id) {
		return pharmacisrservice.updatePharmacist(pharmacistdto,id);
	}
	
	@GetMapping("/getpharmacistbyname")
	public List<PharmacistDto> name(@RequestParam String name) {
		return pharmacisrservice.findPharmacyByName(name);
		
	}
	@GetMapping("/getpharmacistbyemail")
	public PharmacistDto email(@RequestParam String email) {
		return pharmacisrservice.getPharmacyByEmail(email);
	}
	
	@GetMapping("/getbycityandstate")
	public List<PharmacistDto> cityState(@RequestParam String city, @RequestParam String state){
		return pharmacisrservice.findByCityAndState(city, state);
		
	}
	
	@GetMapping("/getbyphone")
	public PharmacistDto getByMobile(@RequestParam Long mobile) {
		return pharmacisrservice.getByMobile(mobile);
		
	}


}
