package com.hospital.management.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@Column(name = "patient_id")
	private String patientId;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "reason_for_visit")
	private String reasonForVisit;

	@Column(name = "attending_doctor_id")
	private String attendingDoctorId;

	public Patient() {
		super();
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public String getAttendingDoctorId() {
		return attendingDoctorId;
	}

	public void setAttendingDoctorId(String attendingDoctorId) {
		this.attendingDoctorId = attendingDoctorId;
	}

	@Override
	public String toString() {
		return "Patient Details:\nPatient ID = " + patientId + ", Patient Name = " + patientName + ", Reason for visit = "
				+ reasonForVisit + ", Attending Doctor ID = " + attendingDoctorId;
	}

}