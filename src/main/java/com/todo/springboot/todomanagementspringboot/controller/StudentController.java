package com.todo.springboot.todomanagementspringboot.controller;

import com.todo.springboot.todomanagementspringboot.model.Student;
import com.todo.springboot.todomanagementspringboot.services.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/student")
@Slf4j
@Api(tags = "Student Controller", value = "Its an API for Student Application")
public class StudentController {
    @Autowired
    private  StudentServiceImpl studentService;


    @PostMapping(value = "/add", produces = "application/json")
    @ApiOperation(value = "Post request to insert student in student list", notes = "")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful response"), @ApiResponse(code = 500, message = "Application Down"), @ApiResponse(code = 400, message = "bad request")})
    public ResponseEntity<String> storeToStudent(@RequestBody Student student) {
        LOGGER.info("hello i reached to controller and now i will go to service  " + student + " received");
       var retVal= studentService.storeToStudent(student);
        LOGGER.info("I have saved  to DB now you can enjoy  " + student + " saving to DB");

        var ret = retVal != null ? new ResponseEntity<>("Saved Successfully", HttpStatus.OK)
               : new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
        return ret;
    }


    @GetMapping(value = "/getAll/", produces = "application/json")
    @ApiOperation(value = "To get all list of Students", notes = "")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful response"), @ApiResponse(code = 500, message = "Application Down"), @ApiResponse(code = 400, message = "bad request")})
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }


}
