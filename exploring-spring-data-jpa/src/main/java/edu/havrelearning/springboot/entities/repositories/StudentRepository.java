package edu.havrelearning.springboot.entities.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import edu.havrelearning.springboot.entities.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {

}
