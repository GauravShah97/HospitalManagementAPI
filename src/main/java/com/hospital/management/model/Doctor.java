package com.hospital.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Doctor {

	@Id
	@Column(name = "doctor_id")
	private String doctorId;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "experience")
	private double experience;

	public Doctor() {
		super();
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Doctor Details:\nDoctor ID = " + doctorId + ", Doctor Name = " + doctorName + ", Specialization = "
				+ specialization + ", Total Experience = " + experience;
	}

}
