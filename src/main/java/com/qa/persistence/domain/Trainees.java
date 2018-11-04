package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainees {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeID;

	private String traineeName;

	@Column(name = "classroomID")
	private Long classroomID;

	public Trainees(String traineeName) {
		this.traineeName = traineeName;
	}

	public Trainees() {

	}

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getClassroomID1() {
		return classroomID;
	}

	public void setClassroomID1(Long classroomID) {
		this.classroomID = classroomID;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + traineeID + ", Trainee Name=" + traineeName + "]";
	}

}
