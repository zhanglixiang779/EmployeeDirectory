package com.example.employeedirectory.data.repository

import com.example.employeedirectory.data.local.datasource.LocalDataSource
import com.example.employeedirectory.data.local.model.LocalEmployee
import com.example.employeedirectory.data.remote.datasource.RemoteDataSource
import com.example.employeedirectory.data.remote.model.ApiEmployee
import com.example.employeedirectory.domain.repository.Repository
import com.example.employeedirectory.domain.model.Employee
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityRetainedScoped
class EmployeesRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val applicationScope: CoroutineScope
) : Repository {

    override fun getEmployees(): Flow<List<Employee>> {
        return localDataSource.getEmployees()
            .onStart {
                applicationScope.launch {
                    val employeesFromRemote = remoteDataSource.getEmployees().employees.map { ApiEmployee.toDomainEmployee(it) }
                    localDataSource.insertEmployees(employeesFromRemote.map { LocalEmployee.fromDomainEmployee(it) })
                }
            }
            .map { localEmployees ->
                localEmployees.map { LocalEmployee.toDomainEmployee(it) }
            }
            .filter { it.isNotEmpty() }
    }
}