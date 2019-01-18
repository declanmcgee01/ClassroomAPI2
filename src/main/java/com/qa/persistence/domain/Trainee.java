package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINEES", schema = "ADMIN")
public class Trainee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long traineeID;
	private String traineeName;
	
	@ManyToOne
	@JoinTable(name="CLASSROOM_TRAINEE",
		joinColumns = @JoinColumn(name = "traineeID",
			referencedColumnName = "traineeID"),
		inverseJoinColumns = @JoinColumn(name = "classroomID",
				referencedColumnName = "classroomID"))
	Trainee trainee;

	
	public Trainee() {
		
	}
	
	public Trainee(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	

}
