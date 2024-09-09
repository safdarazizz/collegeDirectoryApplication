package org.jsp.cda.daoImpl;

import org.jsp.cda.dao.StudentProfileDao;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentProfileDaoImpl implements StudentProfileDao {
	
	@Autowired
	private StudentProfileRepository repository;

	@Override
	public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
		return repository.save(studentProfile);
	}
}
