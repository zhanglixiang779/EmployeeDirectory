package com.example.employeedirectory.presentation.ui.composable

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.employeedirectory.domain.model.Source

@Composable
fun ApplicationScaffold(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Scaffold(
        modifier = modifier.navigationBarsPadding(),
        bottomBar = {
            AppBottomNavBar(
                onEmployeesClicked = {
                    navController.navigate(Destination.Employees(Source.EMPLOYEES)) {
                        popUpTo(Destination.Employees(Source.EMPLOYEES))
                        launchSingleTop = true
                    }
                },
                onEmptyEmployeesClicked = {
                    navController.navigate(Destination.EmptyEmployees(Source.EMPTY)) {
                        launchSingleTop = true
                    }
                },
                onErrorEmployeesClicked = {
                    navController.navigate(Destination.ErrorEmployees(Source.ERROR)) {
                        launchSingleTop = true
                    }
                },
                currentDestination = currentDestination
            )
        }
    ) { paddingValues -> NavGraph(paddingValues, navController) }
}