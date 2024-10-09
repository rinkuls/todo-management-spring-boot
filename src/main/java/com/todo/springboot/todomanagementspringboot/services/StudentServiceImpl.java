package com.todo.springboot.todomanagementspringboot.services;


import com.todo.springboot.todomanagementspringboot.model.Student;
import com.todo.springboot.todomanagementspringboot.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentRepository studentRepository;


    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }


    public Student getStudent(String fName) {

        return studentRepository.findByFirstName(fName);
    }


    public Student storeToStudent(Student student) {
        //Todo todo = todoMapper.mapTodoRequest(todoRequest);
        LOGGER.info("hello i reached to Service  and now i will try to save to DB  " + student + " saving to DB");

        return studentRepository.save(student);

    }


}
