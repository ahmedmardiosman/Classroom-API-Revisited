package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainees {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id

	@Column(name = "Classroom_id")
	private Long classroomID;
	
	private Long traineeID;
	

	private String traineeName;

	public Trainees(String traineeName) {
		this.traineeName = traineeName;
	}

	public Trainees() {

	}

	public Trainees(Long traineeID, String traineeName) {

		this.setTraineeID(traineeID);
		this.setTraineeName(traineeName);

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

	@Override
	public String toString() {
		return "Trainee [id=" + traineeID + ", Trainee Name=" + traineeName + "]";
	}

}
