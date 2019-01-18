package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

@Transactional(SUPPORTS)
@Default
public class TraineeRepositoryImplementation implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject JSONUtil util;
	
	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("Select t FROM Trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"Message\": \"A trainee has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeID) {
		Trainee traineeInDB = findTrainee(traineeID);
		if(traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"Message\": \"Trainee has been deleted\"}";
	}

	@Override
	public String updateTrainee(Long traineeID, String trainee) {
		Trainee traineeToUpdate = findTrainee(traineeID);
		Trainee jsonTrainee = util.getObjectForJSON(trainee, Trainee.class);
		
		if(traineeToUpdate !=null) {
			manager.remove(traineeToUpdate);
			manager.persist(jsonTrainee);
			return "{\"Message\": \"Trainee has been updated\"}";
		}
		return "{\"Message\": \"Trainee did not update\"}";

	}

	@Override
	public Trainee findTrainee(Long traineeID) {
		return manager.find(Trainee.class, traineeID);
	}
	
	private void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
