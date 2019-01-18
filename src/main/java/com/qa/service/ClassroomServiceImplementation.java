package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImplementation implements ClassroomService {
	
	@Inject
	private ClassroomRepository repo;
	@Inject
	private JSONUtil util;
	
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}
	
	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Long classroomID) {
		return repo.deleteClassroom(classroomID);
	}

	@Override
	public String updateClassroom(Long classroomID, String classroom) {
		return repo.updateClassroom(classroomID, classroom);
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}
