package com.todo.todoBackend.service

import com.todo.todoBackend.entity.TaskDt
import com.todo.todoBackend.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepo: TaskRepository) {
    fun add(task: TaskDt?): TaskDt {
        if(task != null) {
            return taskRepo.saveAndFlush(task)
        } else {
            throw NullPointerException()
        }
    }

    fun findAll(): List<TaskDt> {
        return taskRepo.findAll()
    }

    fun update(task: TaskDt): TaskDt {
        val id = task.id ?: throw NullPointerException()
        val updated = taskRepo.findById(id).get()
        return taskRepo.saveAndFlush(task)
    }

    fun deleteById(id: Long): TaskDt {
        val task = taskRepo.findById(id).get()
        taskRepo.deleteById(id)
        return task
    }
}