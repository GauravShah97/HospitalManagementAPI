package com.hospital.management.custom;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.management.model.Patient;

@Repository
public interface CustomRepository extends JpaRepository<Patient, String> {

	@Query(value = "select p.patient_id, p.patient_name, p.reason_for_visit from patient as p join doctor as d on p.attending_doctor_id = d.doctor_id where d.doctor_id = ?1", nativeQuery = true)
	List<String> getPatientsOfDoctor(String doctorId);
	
	@Query(value = "select doctor_id, doctor_name from doctor where specialization = ?1", nativeQuery = true)
	List<String> getDoctorByDisease(String reasonForVisit);
	
	@Transactional
	@Modifying
	@Query(value = "update patient set attending_doctor_id = ?1 where patient_id = ?2", nativeQuery = true)
	int updateAttendingDoctorId( String doctorId, String patientId);
}
