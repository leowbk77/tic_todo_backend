package com.todo.todoBackend.controller

import com.todo.todoBackend.entity.TaskDt
import com.todo.todoBackend.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {
    @PostMapping
    fun addTask(@RequestBody newTask: TaskDt): ResponseEntity<TaskDt> {
        return try {
            ResponseEntity(taskService.add(newTask), HttpStatus.CREATED)
        } catch (e: NullPointerException) {
            ResponseEntity(newTask, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping
    fun getAllTasks(): ResponseEntity<Any> {
        return try {
            ResponseEntity(taskService.findAll(), HttpStatus.OK)
        } catch (e: NullPointerException) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PutMapping
    fun updateTask(@RequestBody updatedTask: TaskDt): ResponseEntity<TaskDt> {
        return try {
            ResponseEntity(taskService.update(updatedTask), HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable(value = "id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(taskService.deleteById(id), HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}