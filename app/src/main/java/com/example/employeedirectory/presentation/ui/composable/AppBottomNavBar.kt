package com.example.employeedirectory.presentation.ui.composable

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import com.example.employeedirectory.domain.model.Source

@Composable
fun AppBottomNavBar(
    onEmployeesClicked: () -> Unit,
    onEmptyEmployeesClicked: () -> Unit,
    onErrorEmployeesClicked: () -> Unit,
    currentDestination: NavDestination?,
) {
    BottomNavigation {
        BottomNavigationItem(
            selected = currentDestination?.route == Source.EMPLOYEES.name,
            onClick = onEmployeesClicked,
            icon = { Icons.Default.Person },
            label = { Text(Source.EMPLOYEES.name) }
        )

        BottomNavigationItem(
            selected = currentDestination?.route == Source.EMPTY.name,
            onClick = onEmptyEmployeesClicked,
            icon = { Icons.Default.Clear },
            label = { Text(Source.EMPTY.name) }
        )
        BottomNavigationItem(
            selected = currentDestination?.route == Source.ERROR.name,
            onClick = onErrorEmployeesClicked,
            icon = { Icons.Default.Warning },
            label = { Text(Source.ERROR.name) }
        )
    }
}