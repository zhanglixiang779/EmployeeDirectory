package com.example.employeedirectory.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.employeedirectory.domain.usecase.EmployeesUseCase
import com.example.employeedirectory.domain.model.Employee
import com.example.employeedirectory.presentation.model.Result
import com.example.employeedirectory.presentation.ui.composable.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class EmployeesViewModel @Inject constructor(
    useCase: EmployeesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val apiSource = savedStateHandle.toRoute<Destination.Employees>().source

    private val refreshTrigger = MutableSharedFlow<Unit>()

    @OptIn(ExperimentalCoroutinesApi::class)
    val employees: StateFlow<Result<List<Employee>>> =
        refreshTrigger
            .onStart { emit(Unit) }
            .flatMapLatest {
                useCase.get(apiSource).getEmployees()
            }
            .map {
                if (!validate(it)) {
                    throw IllegalArgumentException("Invalid employee data")
                }
                Result.Success(it) as Result<List<Employee>>
            }
            .catch { emit(Result.Error(it.localizedMessage.orEmpty())) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Result.Loading
            )

    fun refresh() {
        viewModelScope.launch {
            refreshTrigger.emit(Unit)
        }
    }

    private fun validate(employees: List<Employee>): Boolean {
        employees.forEach {
            if (it.uuid == null || it.fullName == null || it.team == null) {
                return false
            }
        }
        return true
    }
}