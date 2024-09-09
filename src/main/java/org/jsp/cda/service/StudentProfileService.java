package org.jsp.cda.service;

import org.jsp.cda.entity.StudentProfile;
import org.springframework.http.ResponseEntity;

public interface StudentProfileService {

	ResponseEntity<?> saveStudentProfile(StudentProfile studentProfile);

}
