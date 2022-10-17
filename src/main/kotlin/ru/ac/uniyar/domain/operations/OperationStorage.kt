package ru.ac.uniyar.domain.operations

import ru.ac.uniyar.domain.storage.Storage

class OperationStorage(
    storage: Storage,
) {
    val fetchEmployeeOperation: FetchEmployeeOperation = FetchEmployeeOperationImplementation(
        storage.employeeRepository,
    )

    val fetchEquipmentOperation: FetchEquipmentOperation = FetchEquipmentOperationImplementation(
        storage.equipmentRepository,
    )

    val listEmployeesOperation: ListEmployeesOperation = ListEmployeesOperationImplementation(
        storage.employeeRepository,
    )

    val listEquipmentOperation: ListEquipmentOperation = ListEquipmentOperationImplementation(
        storage.equipmentRepository,
    )

    val fetchWithLoginEmployeeOperation: FetchWithLoginEmployeeOperation = FetchWithLoginEmployeeOperationImplementation(
        storage.employeeRepository
    )

    val generateTokenOperation: GenerateTokenOperation = GenerateTokenOperationImplementation()

    val decodeTokenOperation: DecodeTokenOperation= DecodeTokenOperationImplementation()
}
