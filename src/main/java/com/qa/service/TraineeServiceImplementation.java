package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImplementation implements TraineeService {
	
	@Inject
	private TraineeRepository repo;
	@Inject
	private JSONUtil util;
	
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}
	
	@Override
	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(Long traineeID) {
		return repo.deleteTrainee(traineeID);
	}

	@Override
	public String updateTrainee(Long traineeID, String trainee) {
		return repo.updateTrainee(traineeID, trainee);
	}
	
	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

}
