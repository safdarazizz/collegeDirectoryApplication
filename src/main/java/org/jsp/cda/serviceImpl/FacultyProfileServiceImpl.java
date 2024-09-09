package org.jsp.cda.serviceImpl;

import org.jsp.cda.dao.FacultyProfileDao;
import org.jsp.cda.entity.FacultyProfile;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacultyProfileServiceImpl implements FacultyProfileService {
	
	@Autowired
	private FacultyProfileDao dao;

	@Override
	public ResponseEntity<?> saveFacultyProfile(FacultyProfile facultyProfile) {
		FacultyProfile dbFacultyProfile = dao.saveFacultyProfile(facultyProfile);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("FacultyProfile Saved Successfully").body(dbFacultyProfile).build());
	}
}
