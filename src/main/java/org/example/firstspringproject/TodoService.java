package org.example.firstspringproject;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService{
    private List<Todo> todoList = new ArrayList<>();

    public TodoService(){
        todoList.add(new Todo(1, false, "Todo 1", 1));
        todoList.add(new Todo(2, true, "Todo 2", 2));
    }

    public List<Todo> getTodos() {
        return todoList;
    }

    public Todo createTodo(Todo newTodo){
        todoList.add(newTodo);
        return newTodo;
    }

    public Todo getTodoById(int id) {
        return todoList.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteTodo(int id) {
        return todoList.removeIf(todo -> todo.getId() == id);
    }
}