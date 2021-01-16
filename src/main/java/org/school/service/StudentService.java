package org.school.service;

import org.school.DAO.Student;
import org.school.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepo studentRepo;
	
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public Student getStudent(Integer id) {
		return studentRepo.findById(id).get();
	}
}
