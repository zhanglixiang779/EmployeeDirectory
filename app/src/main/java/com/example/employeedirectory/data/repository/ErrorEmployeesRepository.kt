package com.example.employeedirectory.data.repository

import com.example.employeedirectory.data.remote.datasource.RemoteDataSource
import com.example.employeedirectory.data.remote.model.ApiEmployee
import com.example.employeedirectory.domain.repository.Repository
import com.example.employeedirectory.domain.model.Employee
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ActivityRetainedScoped
class ErrorEmployeesRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getEmployees(): Flow<List<Employee>> {
        return flow {
            val employees = remoteDataSource.getEmployeesError().employees.map { ApiEmployee.toDomainEmployee(it) }
            emit(employees)
        }
    }
}