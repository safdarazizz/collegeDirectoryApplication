package org.jsp.cda.service;

import org.jsp.cda.entity.FacultyProfile;
import org.springframework.http.ResponseEntity;

public interface FacultyProfileService {

	ResponseEntity<?> saveFacultyProfile(FacultyProfile facultyProfile);

}
