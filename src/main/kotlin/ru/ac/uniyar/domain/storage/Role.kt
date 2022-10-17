package ru.ac.uniyar.domain.storage

import java.util.*

enum class Role(
    val forbiddenRoutes: Array<String>,
    val id: UUID
) {
    //EquipmentList, EmployeesList, EquipmentInfo, EmployeeInfo
    ADMIN(arrayOf(), UUID.fromString("4ebad11c-a029-43e6-9444-c4102becd85c")),
    USER(arrayOf("/employees"), UUID.fromString("4a0bc5f1-d75e-49d7-9138-9217ee39e95f")),
    GUEST(arrayOf("/employees","/equipment"), UUID.fromString("3c36a6ed-4628-4aeb-b06b-dda211d73bff"));
}
