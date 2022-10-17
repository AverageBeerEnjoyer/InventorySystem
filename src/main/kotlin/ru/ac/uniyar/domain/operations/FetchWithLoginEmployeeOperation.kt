package ru.ac.uniyar.domain.operations

import ru.ac.uniyar.domain.storage.Employee
import ru.ac.uniyar.domain.storage.EmployeeRepository
import java.util.UUID

fun interface FetchWithLoginEmployeeOperation {
    fun fetchWithLogin(login: String): Employee?
}

class FetchWithLoginEmployeeOperationImplementation(
    private val employeeRepository: EmployeeRepository,
) : FetchWithLoginEmployeeOperation {
    override fun fetchWithLogin(login: String): Employee? = employeeRepository.list().firstOrNull {
        it.login==login
    }
}
