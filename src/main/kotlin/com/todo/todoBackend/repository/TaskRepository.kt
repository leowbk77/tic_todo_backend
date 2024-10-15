package com.todo.todoBackend.repository

import com.todo.todoBackend.entity.TaskDt
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository: JpaRepository<TaskDt, Long>