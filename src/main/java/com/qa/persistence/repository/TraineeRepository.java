package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface TraineeRepository {
	
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(Long traineeID);
	String updateTrainee(Long traineeID, String trainee);
	Trainee findTrainee(Long traineeID);

}
