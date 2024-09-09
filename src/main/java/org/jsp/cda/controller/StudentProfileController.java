package org.jsp.cda.controller;

import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/studentProfile")
public class StudentProfileController {
	
	@Autowired
	private StudentProfileService service;
	
	@Operation(summary = "To create a StudentProfile", description = "This API will accept the RequestBody of StudentProfile entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "StudentProfile Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save StudentProfile")})
	@PostMapping
	public ResponseEntity<?> saveStudentProfile(@RequestBody StudentProfile studentProfile)
	{
		return service.saveStudentProfile(studentProfile);
	}
}
