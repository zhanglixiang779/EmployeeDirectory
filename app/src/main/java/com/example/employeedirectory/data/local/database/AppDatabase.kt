package com.example.employeedirectory.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.employeedirectory.data.local.dao.EmployeeDao
import com.example.employeedirectory.data.local.model.LocalEmployee

@Database(entities = [LocalEmployee::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}