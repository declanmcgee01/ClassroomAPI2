package com.qa.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

import com.qa.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({"application/json"})
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/deleteClassroom/{classroomID}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClassroom(@PathParam("classroomID")Long classroomID) {
		return service.deleteClassroom(classroomID);
	}
	
	@Path("updateClassroom/{classroomID}")
	@PUT
	@Produces({"application/json"})
	public String updateClassroom(@PathParam("classroomID")Long classroomID, String classroom) {
		return service.updateClassroom(classroomID, classroom);
	}

}
