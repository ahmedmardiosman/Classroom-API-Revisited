package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllClassrooms();

	String getAllTrainees();

	String updateClassroom(Long classroomID,String classroom);

	String createClassroom(String trainer);

	String createTrainee(String trainee);

	String deleteClassroom(Long classroomID);

	String deleteTrainee(Long traineeID);

}