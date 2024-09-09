package org.jsp.cda.controller;

import java.io.File;
import java.io.IOException;

import org.jsp.cda.entity.Profile;
import org.jsp.cda.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	
	@Autowired
	private ProfileRepository repository;
	
	private static final String FOLDER_PATH = "/Users/safdarazizz/Developer/workspace-spring-tool-suite-4-4.24.0.RELEASE/Images/";
	
	@Operation(summary = "To create a Profile", description = "This API will accept the RequestBody of Profile entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Profile Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save Profile")})
	@PostMapping
	public Profile saveProfile(@RequestParam MultipartFile file, Profile profile)
	{
		String fileName = file.getOriginalFilename();
		
		String path = FOLDER_PATH + fileName;
		
		String type = file.getContentType();
		
		try
		{
			file.transferTo(new File(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		profile.setName(fileName);
		profile.setType(type);
		profile.setPath(path);
		
		return repository.save(profile);
	}
}
