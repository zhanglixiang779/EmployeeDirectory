package com.example.employeedirectory.presentation.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.employeedirectory.domain.model.Source
import kotlinx.serialization.Serializable

@Serializable
sealed class Destination {
    @Serializable
    data class Employees(val source: Source) : Destination()
    @Serializable
    data class EmptyEmployees(val source: Source) : Destination()
    @Serializable
    data class ErrorEmployees(val source: Source) : Destination()
}

@Composable
fun NavGraph(paddingValues: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.Employees(Source.EMPLOYEES)
    ) {

        composable<Destination.Employees> { EmployeesScreen(paddingValues) }

        composable<Destination.EmptyEmployees> { EmployeesScreen(paddingValues) }

        composable<Destination.ErrorEmployees> { EmployeesScreen(paddingValues) }
    }
}