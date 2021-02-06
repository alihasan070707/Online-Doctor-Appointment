package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
		
		@Query(value="select distinct a.city from Address AS a where a.state=:state")
		List<String> findCityByState(@Param("state") String state);
		
		@Query(value="select distinct state from Address")
		List<String> findAllState();
		
		@Query(value="select distinct specialization from Doctor where Id in (select doctorId from Address where state=:state AND city=:city)")
		List<String> findBySpecialization(@Param("state") String state, @Param("city") String city);
		
		@Query(value="select d from Doctor d where Id in (select doctorId from Address where state=:state AND city=:city)")
		List<Doctor> searchDoctorByStateAndCity(@Param("state") String state, @Param("city") String city);
		
		@Query(value="select d from Doctor d where Id in (select doctorId from Address where state=:state AND city=:city) AND specialization=:spec")
		List<Doctor> searchDoctorByAll(@Param("state") String state, @Param("city") String city, @Param("spec") String spec);
		
		Optional<Doctor> findById(Integer id);
		
		List<Doctor> findAllByIsVerified(boolean status);
}
