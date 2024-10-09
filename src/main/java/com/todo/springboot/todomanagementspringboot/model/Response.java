package com.todo.springboot.todomanagementspringboot.model;

import lombok.Data;

@Data
public class Response {

    private boolean success;
    private String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}
