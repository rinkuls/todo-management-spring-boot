package com.todo.springboot.todomanagementspringboot.services;


import com.todo.springboot.todomanagementspringboot.model.Todo;
import com.todo.springboot.todomanagementspringboot.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
//@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl {
    private final TodoRepository todoRepository;



    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }


    public Todo getTodo(int id) {
        Optional<Todo> todo = todoRepository.findById((long) id);
        return todo.orElse(null);
    }


    public Todo storeTodo(Todo todoRequest) {
        //Todo todo = todoMapper.mapTodoRequest(todoRequest);
        return todoRepository.save(todoRequest);
    }


    public boolean deleteTodo(int id) {
        boolean deleted = false;
        Optional<Todo> todo = todoRepository.findById((long) id);

        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
            deleted = true;
        }
        return deleted;
    }
}
