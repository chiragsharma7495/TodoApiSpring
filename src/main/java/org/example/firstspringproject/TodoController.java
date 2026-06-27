package org.example.firstspringproject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TodoController {

    private static List<Todo> TodoList;

    public TodoController(){
        TodoList = new ArrayList<>();
        TodoList.add(new Todo(1, false , "Todo 1" , 1));
        TodoList.add(new Todo(2, true , "Todo 2" , 2));
    }

    @GetMapping("/todos")
    public List <Todo> getTodos(){
        return TodoList;
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo){
        TodoList.add(newTodo);
        return newTodo;
    }

}
