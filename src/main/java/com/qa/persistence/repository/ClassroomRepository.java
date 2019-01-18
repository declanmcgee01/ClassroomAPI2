package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {
	
	String getAllClassrooms();
	String createClassroom(String classroom);
	String deleteClassroom(Long classroomID);
	String updateClassroom(Long classroomID, String classroom);
	Classroom findClassroom(Long classroomid);

}
