package org.example.firstspringproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;
    private final ForAnnotationMethod forAnnotationMethod;



    // Constructor Injection
    public TodoController(TodoService todoService, ForAnnotationMethod forAnnotationMethod) {
        this.todoService = todoService;
        this.forAnnotationMethod = forAnnotationMethod;
    }

    @GetMapping("/test-annotation")
    public String testAnnotation() {
        // This calls the method marked with @TimeMonitor
        // The TimeMonitorAspect will intercept and log execution time
        return forAnnotationMethod.doSomething();
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo newTodo) {
        return todoService.createTodo(newTodo);
    }

    @GetMapping("/{todoID}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int todoID) {
        Todo todo = todoService.getTodoById(todoID);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{todoID}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoID) {
        if (todoService.deleteTodo(todoID)) {
            return ResponseEntity.ok("Todo deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
