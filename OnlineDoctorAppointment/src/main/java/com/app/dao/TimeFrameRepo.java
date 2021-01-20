package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Doctor;
import com.app.pojos.TimeFrame;

public interface TimeFrameRepo extends JpaRepository<TimeFrame, Integer> {
	public List<TimeFrame> findAllByDrIdAndDate(Doctor drId,LocalDate date);
}
