package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Address;
import com.app.pojos.Doctor;

public interface DoctorRepsitory extends JpaRepository<Doctor, Integer>{
	
		List<Doctor> findAllByAddressAndSpecializationAndIsVerifiedTrue(Address address,String specialization);
		
		@Query(value = "insert into Prescription values(:patientId,:prescriptionPdf)")
		void setPatientsPrescription(@Param("PatientId") Integer patientId ,@Param("prescriptionPdf") byte[] prescriptionPdf);
		
		
}
