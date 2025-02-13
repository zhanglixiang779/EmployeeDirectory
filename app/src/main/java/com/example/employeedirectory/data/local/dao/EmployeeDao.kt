package com.example.employeedirectory.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.employeedirectory.data.local.model.LocalEmployee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployees(employees: List<LocalEmployee>)

    @Query("SELECT * FROM employees")
    fun getEmployees(): Flow<List<LocalEmployee>>
}