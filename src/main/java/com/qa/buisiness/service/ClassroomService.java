package com.qa.buisiness.service;

public interface ClassroomService {

	String getAllClassrooms();
	
	String getAllTrainees();

	String updateClassroom(String classroom);

	String createClassroom(String trainer);
	
	String createTrainee(String trainee);

	String deleteClassroom(Long ClassroomID);
	
	String deleteTrainee(Long ClassroomID);
}