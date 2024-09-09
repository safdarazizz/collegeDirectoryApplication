package org.jsp.cda.serviceImpl;

import org.jsp.cda.dao.StudentProfileDao;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService{
	
	@Autowired
	private StudentProfileDao dao;

	@Override
	public ResponseEntity<?> saveStudentProfile(StudentProfile studentProfile) {
		StudentProfile dbStudentProfile = dao.saveStudentProfile(studentProfile);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("StudentProfile Saved Successfully").body(dbStudentProfile).build());
	}
}
