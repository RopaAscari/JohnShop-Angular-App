package database;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Student;


public interface IStudentDatabase extends JpaRepository<Student,Integer>  {

}


