package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classrooms;
import com.qa.persistence.domain.Trainees;
import com.qa.util.JSONUtil;

// Class to add stuff to database

@Transactional(SUPPORTS)
@Default
@ApplicationScoped
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonConverter;

	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classrooms a");
		Collection<Classrooms> classrooms = (Collection<Classrooms>) query.getResultList();
		return jsonConverter.getJSONForObject(classrooms);
	}

	public String getAllTrainees() {
		Query query = manager.createQuery("Select t FROM Trainees t");
		Collection<Trainees> trainees = (Collection<Trainees>) query.getResultList();
		return jsonConverter.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String trainer) {
		Classrooms aClassroom = jsonConverter.getObjectForJSON(trainer, Classrooms.class);
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added.\"}";
	}

	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainees aTrainee = jsonConverter.getObjectForJSON(trainee, Trainees.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added.\"}";
	}

	@Transactional(REQUIRED)
	public String updateClassroom(String classroom) {
		Classrooms aClassroom = jsonConverter.getObjectForJSON(classroom, Classrooms.class);
		Classrooms classroomInDB = findClassroom(aClassroom.getClassroomID());
		if (classroomInDB != null) {
			classroomInDB.setTrainer(aClassroom.getTrainer());
			classroomInDB.setTrainees(aClassroom.getTrainees());
		}
		return "{\"message\": \"classroom has been sucessfully updated.\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomID) {
		Classrooms classroomInDB = findClassroom(classroomID);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted.\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeID) {
		Trainees traineeInDB = findTrainee(traineeID);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"Trainee sucessfully deleted.\"}";
	}

	private Trainees findTrainee(Long traineeID) {
		return manager.find(Trainees.class, traineeID);
	}

	private Classrooms findClassroom(Long classroomID) {
		return manager.find(Classrooms.class, classroomID);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil jsonConverter) {
		this.jsonConverter = jsonConverter;
	}

}