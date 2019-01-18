package com.qa.service;

public interface ClassroomService {
	
	String getAllClassrooms();
	
	String createClassroom(String classroom);
	
	String deleteClassroom(Long classroomID);
	
	String updateClassroom(Long classroomID, String classroom);

}
