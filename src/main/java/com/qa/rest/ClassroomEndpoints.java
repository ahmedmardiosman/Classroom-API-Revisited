package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.buisiness.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoints {

	@Inject
	private ClassroomService service;

	@Path("/getClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}

	@Path("/getTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String trainer) {
		return service.createClassroom(trainer);
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long classroomID) {
		return service.deleteClassroom(classroomID);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long traineeID) {
		return service.deleteTrainee(traineeID);
	}

	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long classroomID, String classroom) {
		return service.updateClassroom(classroomID, classroom);
	}

}
