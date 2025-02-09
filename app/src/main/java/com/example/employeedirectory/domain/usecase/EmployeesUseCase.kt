package com.example.employeedirectory.domain.usecase

import com.example.employeedirectory.di.Employees
import com.example.employeedirectory.di.EmptyEmployees
import com.example.employeedirectory.di.ErrorEmployees
import com.example.employeedirectory.domain.model.Source
import com.example.employeedirectory.domain.repository.Repository
import javax.inject.Inject

class EmployeesUseCase @Inject constructor(
    @Employees private val employeesRepository: Repository,
    @EmptyEmployees private val emptyEmployeesRepository: Repository,
    @ErrorEmployees private val errorEmployeesRepository: Repository
) {
    fun get(source: Source): Repository {
        return when (source) {
            Source.EMPLOYEES -> employeesRepository
            Source.EMPTY -> emptyEmployeesRepository
            Source.ERROR -> errorEmployeesRepository
        }
    }
}