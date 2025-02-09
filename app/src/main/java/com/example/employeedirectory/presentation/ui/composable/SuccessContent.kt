package com.example.employeedirectory.presentation.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.employeedirectory.domain.model.Employee

@Composable
fun SuccessContent(
    employees: List<Employee>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        val key = { employee: Employee -> employee.uuid ?: employee.fullName.orEmpty() }
        items(items = employees, key = key) { employee ->
            EmployeeItem(employee)
        }
    }
}