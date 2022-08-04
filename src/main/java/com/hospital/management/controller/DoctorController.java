package com.hospital.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.model.Doctor;
import com.hospital.management.repository.DoctorRepository;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;

	@GetMapping("/list")
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable(value = "id") String id){
		return doctorRepository.findById(id);
	}

	@PostMapping
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable(value = "id") String id) {
		doctorRepository.deleteById(id);
	}

}
