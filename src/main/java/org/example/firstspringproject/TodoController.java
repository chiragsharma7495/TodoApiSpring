package org.example.firstspringproject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> TodoList;

    public TodoController(){
        TodoList = new ArrayList<>();
        TodoList.add(new Todo(1, false , "Todo 1" , 1));
        TodoList.add(new Todo(2, true , "Todo 2" , 2));
    }

    @GetMapping
    public List <Todo> getTodos(){
        return TodoList;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo newTodo){
        TodoList.add(newTodo);
        return newTodo;
    }

    @GetMapping("/{todoID}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("todoID") long todoID){
        for(Todo todo : TodoList){
            if(todo.getId() == todoID) return ResponseEntity.ok(todo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{todoID}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoID){
        for(Todo todo : TodoList){
            if(todo.getId() == todoID) {
                TodoList.remove(todo);
                return ResponseEntity.ok("Todo Deleted Successfully");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
