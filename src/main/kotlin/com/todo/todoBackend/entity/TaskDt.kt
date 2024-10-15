package com.todo.todoBackend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table

@Entity
@Table(name = "task")
data class TaskDt(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                  val nome: String)
