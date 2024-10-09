package com.todo.springboot.todomanagementspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "health Resource", value = "Its a health Check for Application")
public class HealthCheckController {
    @GetMapping(value = "/health", produces = "application/json")
    @ApiOperation(value = "health check for application", notes = "")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful response"), @ApiResponse(code = 500, message = "Application Down")})
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
