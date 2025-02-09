package com.example.employeedirectory.data.datasource

import com.example.employeedirectory.data.service.EmployeesService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val employeesService: EmployeesService
) {
    suspend fun getEmployees() = employeesService.getEmployees()

    suspend fun getEmployeesEmpty() = employeesService.getEmployeesEmpty()

    suspend fun getEmployeesError() = employeesService.getEmployeesError()
}