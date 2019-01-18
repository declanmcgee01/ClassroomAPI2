package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

@Transactional(SUPPORTS)
@Default
public class ClassroomRepositoryImplementation implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject JSONUtil util;
	
	@Override
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select c FROM Classroom c");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"Message\": \"A classroom has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomID) {
		Classroom classroomInDB = findClassroom(classroomID);
		if(classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"Message\": \"Classroom has been deleted\"}";
	}

	@Override
	public String updateClassroom(Long classroomID, String classroom) {
		Classroom classroomToUpdate = findClassroom(classroomID);
		Classroom jsonClassroom = util.getObjectForJSON(classroom, Classroom.class);
		
		if(classroomToUpdate !=null) {
			manager.remove(classroomToUpdate);
			manager.persist(jsonClassroom);
			return "{\"Message\": \"Classroom has been updated\"}";
		}
		return "{\"Message\": \"Classroom did not update\"}";

	}

	@Override
	public Classroom findClassroom(Long classroomID) {
		return manager.find(Classroom.class, classroomID);
	}
	
	private void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
