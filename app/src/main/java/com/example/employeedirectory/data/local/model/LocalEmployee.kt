package com.example.employeedirectory.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.employeedirectory.domain.model.Employee

@Entity(tableName = "employees")
data class LocalEmployee(

    @PrimaryKey
    val uuid: String,
    @ColumnInfo(name = "full_name")
    val fullName: String? = null,
    val team: String? = null,
    val photoUrlSmall: String? = null,
) {
    companion object {
        fun toDomainEmployee(localEmployee: LocalEmployee): Employee {
            return Employee(
                uuid = localEmployee.uuid,
                fullName = localEmployee.fullName,
                team = localEmployee.team,
                photoUrlSmall = localEmployee.photoUrlSmall
            )
        }

        fun fromDomainEmployee(employee: Employee): LocalEmployee {
            return LocalEmployee(
                uuid = employee.uuid.orEmpty(),
                fullName = employee.fullName,
                team = employee.team,
                photoUrlSmall = employee.photoUrlSmall
            )
        }
    }
}
