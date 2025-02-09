package com.example.employeedirectory

import org.junit.Test
import com.example.employeedirectory.domain.usecase.EmployeesUseCase
import com.example.employeedirectory.domain.model.Source
import com.example.employeedirectory.fake.FakeRepository
import org.junit.Assert.assertEquals
import org.junit.Before

class EmployeesUseCaseTest {

    private lateinit var employeesRepository: FakeRepository
    private lateinit var emptyEmployeesRepository: FakeRepository
    private lateinit var errorEmployeesRepository: FakeRepository
    private lateinit var employeesUseCase: EmployeesUseCase

    @Before
    fun setUp() {
        employeesRepository = FakeRepository()
        emptyEmployeesRepository = FakeRepository()
        errorEmployeesRepository = FakeRepository()

        employeesUseCase = EmployeesUseCase(
            employeesRepository,
            emptyEmployeesRepository,
            errorEmployeesRepository
        )
    }

    @Test
    fun `should return employeesRepository when Route is EMPLOYEES`() {
        val result = employeesUseCase.get(Source.EMPLOYEES)
        assertEquals(employeesRepository, result)
    }

    @Test
    fun `should return emptyEmployeesRepository when Route is EMPTY`() {
        val result = employeesUseCase.get(Source.EMPTY)
        assertEquals(emptyEmployeesRepository, result)
    }

    @Test
    fun `should return errorEmployeesRepository when Route is ERROR`() {
        val result = employeesUseCase.get(Source.ERROR)
        assertEquals(errorEmployeesRepository, result)
    }
}