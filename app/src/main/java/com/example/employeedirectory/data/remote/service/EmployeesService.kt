package com.example.employeedirectory.data.remote.service

import com.example.employeedirectory.constant.EMPTY_API_ENDPOINT
import com.example.employeedirectory.constant.ERROR_API_ENDPOINT
import com.example.employeedirectory.constant.SUCCESS_API_ENDPOINT
import com.example.employeedirectory.data.remote.model.ApiEmployees
import retrofit2.http.GET

interface EmployeesService {

    @GET(SUCCESS_API_ENDPOINT)
    suspend fun getEmployees(): ApiEmployees

    @GET(EMPTY_API_ENDPOINT)
    suspend fun getEmployeesEmpty(): ApiEmployees

    @GET(ERROR_API_ENDPOINT)
    suspend fun getEmployeesError(): ApiEmployees
}