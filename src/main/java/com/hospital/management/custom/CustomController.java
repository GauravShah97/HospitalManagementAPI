package com.hospital.management.custom;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class CustomController {

	@Autowired
	CustomRepository customRepository;

	/** Retrieve all the patients under a doctor using Doctor ID */
	@GetMapping("/patients/{doctorid}")
	public ResponseEntity<List<Object>> getPatientsOfDoctor(@PathVariable("doctorid") String doctorId)
			throws JsonMappingException, JsonProcessingException {
		List<String> listFromDb = customRepository.getPatientsOfDoctor(doctorId);
		List<Object> patientList = new ArrayList<>();
		for (String row : listFromDb) {
			String[] entries = row.split(",");
			JSONObject patientDetails = new JSONObject();
			patientDetails.put("patientId", entries[0]);
			patientDetails.put("patientName", entries[1]);
			patientDetails.put("reasonForVisit", entries[2]);
			Object object = new ObjectMapper().readValue(patientDetails.toString(), Object.class);
			patientList.add(object);
		}
		if (patientList.isEmpty()) {
			patientList.add("No patients are currently under this doctor");
			return new ResponseEntity<List<Object>>(patientList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Object>>(patientList, HttpStatus.OK);
	}

	/** Retrieve all the doctors available with a particular Specialization */
	@GetMapping("/doctors/{specialization}")
	public ResponseEntity<List<Object>> getDoctorByDisease(@PathVariable("specialization") String specialization)
			throws JsonMappingException, JsonProcessingException {
		List<String> listFromDb = customRepository.getDoctorByDisease(specialization);
		List<Object> doctorList = new ArrayList<>();
		for (String row : listFromDb) {
			String[] entries = row.split(",");
			JSONObject doctorDetails = new JSONObject();
			doctorDetails.put("doctorId", entries[0]);
			doctorDetails.put("doctorName", entries[1]);
			Object object = new ObjectMapper().readValue(doctorDetails.toString(), Object.class);
			doctorList.add(object);
		}
		if (doctorList.isEmpty()) {
			doctorList.add("No doctors are currently available for the requested specialization");
			return new ResponseEntity<List<Object>>(doctorList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Object>>(doctorList, HttpStatus.OK);
	}

	/** Update Attending Doctor ID for a particular Patient */
	@PutMapping("/patient/{patientid}/{doctorid}")
	public ResponseEntity<String> updateAttendingDoctorId(@PathVariable("patientid") String patientId,
			@PathVariable("doctorid") String doctorId) {
		int check = customRepository.updateAttendingDoctorId(doctorId, patientId);
		if (check == 1)
			return new ResponseEntity<String>("Patient found and updated successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Unable to update the patient. Please verify the details.",
					HttpStatus.NOT_FOUND);
	}
}