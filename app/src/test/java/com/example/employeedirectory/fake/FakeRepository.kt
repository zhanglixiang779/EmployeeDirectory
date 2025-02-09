package com.example.employeedirectory.fake

import com.example.employeedirectory.domain.model.Employee
import com.example.employeedirectory.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeRepository : Repository {
    private val employeesFlow = MutableStateFlow<List<Employee>>(emptyList())

    override fun getEmployees(): Flow<List<Employee>> {
        return employeesFlow
    }
}