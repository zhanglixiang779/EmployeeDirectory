package com.example.employeedirectory.data.local.datasource

import com.example.employeedirectory.data.local.dao.EmployeeDao
import com.example.employeedirectory.data.local.model.LocalEmployee
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val employeeDao: EmployeeDao
) {

    suspend fun insertEmployees(employees: List<LocalEmployee>) {
        return employeeDao.insertEmployees(employees)
    }

    fun getEmployees() = employeeDao.getEmployees()
}