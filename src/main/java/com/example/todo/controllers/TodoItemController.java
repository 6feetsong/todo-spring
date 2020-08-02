package com.example.todo.controllers;

import com.example.todo.models.*;

import com.example.todo.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TodoItemController {

    @Autowired
    private TodoItemService itemService;

    @GetMapping("/item/{itemId}")
    public TodoItem getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }

    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    public List<TodoItem> getItem(@PathVariable UUID listId) {
        return itemService.getAllTodoItemsForListId(listId);
    }

    // New todo item
    @PostMapping(value = "/new")
    public ResponseEntity<TodoItem> newTodoItem(@RequestBody TodoItem item) {
        return ResponseEntity.ok(itemService.saveTodoItem(item));
    }

    // Edit todo item
    @PutMapping("/edit")
    public ResponseEntity<TodoItem> editTodoItem(@RequestBody TodoItem item) {
        return ResponseEntity.ok(itemService.editTodoItem(item));
    }

    // Delete todo item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTodoItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteTodoItem(id));
    }

    // Change done state
    @PutMapping("/state/{id}")
    public ResponseEntity<TodoItem> changeDoneState(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.changeDoneStateForTodoItem(id));
    }

}
