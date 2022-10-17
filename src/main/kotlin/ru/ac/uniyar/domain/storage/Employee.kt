package ru.ac.uniyar.domain.storage

import java.util.UUID

data class Employee(
    val id: UUID,
    val name: String,
    val login: String,
    val phone: String,
    val role: Role,
    val password: String
)
