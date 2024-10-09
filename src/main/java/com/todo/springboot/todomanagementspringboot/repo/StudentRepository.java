package com.todo.springboot.todomanagementspringboot.repo;

import com.todo.springboot.todomanagementspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFirstName(String firstName);
}
