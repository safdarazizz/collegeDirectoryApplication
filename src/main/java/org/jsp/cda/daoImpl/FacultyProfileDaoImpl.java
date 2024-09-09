package org.jsp.cda.daoImpl;

import org.jsp.cda.dao.FacultyProfileDao;
import org.jsp.cda.entity.FacultyProfile;
import org.jsp.cda.repository.FacultyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyProfileDaoImpl implements FacultyProfileDao {
	
	@Autowired
	private FacultyProfileRepository repository;

	@Override
	public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
		return repository.save(facultyProfile);
	}
}
