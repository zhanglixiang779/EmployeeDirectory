package com.example.employeedirectory.domain.repository

import com.example.employeedirectory.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface Repository {

    /**
     * Get employees from the repository
     */
    fun getEmployees(): Flow<List<Employee>>
}