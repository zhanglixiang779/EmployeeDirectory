package com.example.employeedirectory.di

import com.example.employeedirectory.domain.repository.Repository
import com.example.employeedirectory.data.repository.EmployeesRepository
import com.example.employeedirectory.data.repository.EmptyEmployeesRepository
import com.example.employeedirectory.data.repository.ErrorEmployeesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @ActivityRetainedScoped
    @Employees
    @Binds
    abstract fun bindsEmployeesRepository(employeesRepository: EmployeesRepository): Repository

    @ActivityRetainedScoped
    @EmptyEmployees
    @Binds
    abstract fun bindsEmptyEmployeesRepository(employeesRepository: EmptyEmployeesRepository): Repository

    @ActivityRetainedScoped
    @ErrorEmployees
    @Binds
    abstract fun bindsErrorEmployeesRepository(employeesRepository: ErrorEmployeesRepository): Repository
}