package com.example.employeedirectory.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Employees

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EmptyEmployees

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ErrorEmployees