package com.todo.springboot.todomanagementspringboot.controller;

import com.todo.springboot.todomanagementspringboot.model.Todo;
import com.todo.springboot.todomanagementspringboot.services.TodoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Todo Controller", value = "Its an API for TODO Application")
public class TodoController {
    private final TodoServiceImpl todoService;




    @PostMapping(value = "/todo/add", produces = "application/json")
    @ApiOperation(value = "Post request to insert todo in todo list", notes = "")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful response"), @ApiResponse(code = 500, message = "Application Down"), @ApiResponse(code = 400, message = "bad request")})
    public ResponseEntity<String> storeTodo(@RequestBody Todo todo) {
        return todoService.storeTodo(todo) != null ? new ResponseEntity<>("Saved Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
    }


    @GetMapping(value = "/todo/update/", produces = "application/json")
    @ApiOperation(value = "To get all list of TODOs", notes = "")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful response"), @ApiResponse(code = 500, message = "Application Down"), @ApiResponse(code = 400, message = "bad request")})
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }



}
