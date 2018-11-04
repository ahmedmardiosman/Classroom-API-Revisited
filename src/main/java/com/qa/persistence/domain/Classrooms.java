package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classrooms {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	
	@Column(name = "classroomID")
	private Long classroomID;
	
	private String trainer;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "classroomID", referencedColumnName = "classroomID")
	private List<Trainees> traineeList;

	public Classrooms() {

	}

	public Classrooms(String trainer, List<Trainees> traineeList) {
		this.trainer = trainer;
		this.traineeList = traineeList;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public List<Trainees> getTrainees() {
		return traineeList;
	}

	public void setTrainees(List<Trainees> Trainees) {
		this.traineeList = Trainees;
	}

}
