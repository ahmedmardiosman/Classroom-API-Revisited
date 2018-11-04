package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllClassrooms();

	String getAllTrainees();

	String updateClassroom(String classroom);

	String createClassroom(String classroom);

	String createTrainee(String trainee);

	String deleteClassroom(Long ClassroomID);

	String deleteTrainee(Long ClassroomID);

}