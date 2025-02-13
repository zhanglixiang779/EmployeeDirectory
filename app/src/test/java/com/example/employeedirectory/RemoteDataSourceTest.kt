package com.example.employeedirectory

import com.example.employeedirectory.data.remote.datasource.RemoteDataSource
import com.example.employeedirectory.data.remote.model.ApiEmployee
import com.example.employeedirectory.data.remote.model.ApiEmployees
import com.example.employeedirectory.fake.FakeEmployeesService
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RemoteDataSourceTest {

    private lateinit var fakeEmployeesService: FakeEmployeesService
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        fakeEmployeesService = FakeEmployeesService()
        remoteDataSource = RemoteDataSource(fakeEmployeesService)
    }

    @Test
    fun `getEmployees should return employees data`() = runTest {
        // Given
        val expectedResponse = ApiEmployees(
            listOf(
                ApiEmployee(uuid = "1", fullName = "John Doe", team = "Engineering"),
                ApiEmployee(uuid = "2", fullName = "Jane Smith", team = "Design")
            )
        )
        fakeEmployeesService.setEmployeesResponse(expectedResponse)

        // When
        val result = remoteDataSource.getEmployees()

        // Then
        assertEquals(expectedResponse, result)
    }

    @Test
    fun `getEmployeesEmpty should return empty employees data`() = runTest {
        // Given
        val expectedResponse = ApiEmployees(emptyList())
        fakeEmployeesService.setEmptyEmployeesResponse(expectedResponse)

        // When
        val result = remoteDataSource.getEmployeesEmpty()

        // Then
        assertEquals(expectedResponse, result)
    }

    @Test
    fun `getEmployeesError should throw exception`() = runTest {
        // Given
        val exception = RuntimeException("Error fetching employees")
        fakeEmployeesService.setErrorResponse(exception)

        // When/Then
        try {
            remoteDataSource.getEmployeesError()
            fail("Expected an exception to be thrown")
        } catch (e: Exception) {
            assertEquals(exception.message, e.message)
        }
    }
}