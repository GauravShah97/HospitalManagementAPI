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

import com.hospital.management.model.Patient;
import com.hospital.management.repository.PatientRepository;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	
	@GetMapping("/list")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Patient> getPatientById(@PathVariable(value = "id") String id) {
		return patientRepository.findById(id);
	}
	
	@PostMapping
	public Patient addPatient(@RequestBody Patient patient) {
	return patientRepository.save(patient);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatientById(@PathVariable(value = "id") String id) {
		patientRepository.deleteById(id);
	}

}
