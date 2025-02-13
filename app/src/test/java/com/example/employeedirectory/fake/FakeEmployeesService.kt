package com.example.employeedirectory.fake

import com.example.employeedirectory.data.remote.model.ApiEmployees
import com.example.employeedirectory.data.remote.service.EmployeesService

class FakeEmployeesService : EmployeesService {
    private var employeesResponse: ApiEmployees? = null
    private var emptyEmployeesResponse: ApiEmployees? = null
    private var errorResponse: Throwable? = null

    fun setEmployeesResponse(response: ApiEmployees) {
        employeesResponse = response
    }

    fun setEmptyEmployeesResponse(response: ApiEmployees) {
        emptyEmployeesResponse = response
    }

    fun setErrorResponse(error: Throwable) {
        errorResponse = error
    }

    override suspend fun getEmployees(): ApiEmployees {
        errorResponse?.let { throw it }
        return employeesResponse ?: throw IllegalStateException("No response set")
    }

    override suspend fun getEmployeesEmpty(): ApiEmployees {
        errorResponse?.let { throw it }
        return emptyEmployeesResponse ?: throw IllegalStateException("No response set")
    }

    override suspend fun getEmployeesError(): ApiEmployees {
        throw errorResponse ?: IllegalStateException("No error set")
    }
}