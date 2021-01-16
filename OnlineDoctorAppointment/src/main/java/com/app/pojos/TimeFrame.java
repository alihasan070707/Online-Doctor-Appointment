package com.app.pojos;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TimeFrame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name="doctor_id")
	@ManyToOne
	private Integer drId;
	
	@DateTimeFormat(pattern="hh:mm:ss")
	private Time startTime;
	
	@DateTimeFormat(pattern="hh:mm:ss")
	private Time endTime;
	
	@Column(name="is_booked")
	private boolean isBooked;
	
	public TimeFrame() {
		super();
	}

	public TimeFrame(Integer drId, Time startTime, Time endTime, boolean isBooked) {
		super();
		this.drId = drId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isBooked = isBooked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDrId() {
		return drId;
	}

	public void setDrId(Integer drId) {
		this.drId = drId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "TimeFrame [id=" + id + ", drId=" + drId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", isBooked=" + isBooked + "]";
	}
	
	
}
