package com.example.employeedirectory.presentation.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.employeedirectory.presentation.model.Result.Loading
import com.example.employeedirectory.presentation.model.Result.Success
import com.example.employeedirectory.presentation.model.Result.Error
import com.example.employeedirectory.presentation.viewmodel.EmployeesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeesScreen(
    paddingValues: PaddingValues,
    viewModel: EmployeesViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    var shouldShowIndicator by remember {
        mutableStateOf(false)
    }

    var isRefreshing by remember {
        mutableStateOf(false)
    }

    val state = viewModel.employees.collectAsStateWithLifecycle().value

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            viewModel.refresh()
        },
        modifier = Modifier.padding(paddingValues)
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            when (state) {
                is Success -> {
                    val employees = state.data
                    if (employees.isNotEmpty()) {
                        SuccessContent(employees, modifier)
                    } else {
                        EmptyContent(modifier)
                    }
                    shouldShowIndicator = false
                    isRefreshing = false
                }
                is Error -> {
                    ErrorContent(modifier)
                    shouldShowIndicator = false
                    isRefreshing = false
                }
                is Loading -> {
                    shouldShowIndicator = true
                    isRefreshing = false
                }
            }
            ProgressIndicator(shouldShowIndicator)
        }
    }
}