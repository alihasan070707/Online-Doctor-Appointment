package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.TimeFrame;

public interface TimeFrameRepo extends JpaRepository<TimeFrame, Integer> {

}
