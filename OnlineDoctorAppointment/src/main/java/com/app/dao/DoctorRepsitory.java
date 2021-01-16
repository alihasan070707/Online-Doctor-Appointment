package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Address;
import com.app.pojos.Doctor;

public interface DoctorRepsitory extends JpaRepository<Doctor, Integer>{
	
		List<Doctor> findAllByAddressAndSpecializationAndIsVerifiedTrue(Address address,String specialization);
		
		/*
		 * @Query(value =
		 * "insert into Prescription(prescription_pdf,patient_id) values(:patientId,:prescriptionPdf)"
		 * ) void setPatientsPrescription(@Param("PatientId") Integer patientId
		 * ,@Param("prescriptionPdf") byte[] prescriptionPdf);
		 */
		
		Optional<Doctor> findByEmailAndPassword(String email, char[] password);
		
		
}
