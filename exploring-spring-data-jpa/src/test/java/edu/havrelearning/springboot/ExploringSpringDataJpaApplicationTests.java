package edu.havrelearning.springboot;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.havrelearning.springboot.entities.Student;
import edu.havrelearning.springboot.entities.repositories.StudentRepository;



@SpringBootTest
class ExploringSpringDataJpaApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	void testSaveStudent() {
		
		Student entity = new Student();
		entity.setId(1l);
		entity.setName("Alfa");
		entity.setTestScore(100);
		studentRepository.save(entity);
		
		Student savedStudent = studentRepository.findById(1l).get();
		
		assertNotNull(savedStudent);
		
	}

}
