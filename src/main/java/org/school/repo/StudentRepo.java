package org.school.repo;

import javax.transaction.Transactional;

import org.school.DAO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
}
