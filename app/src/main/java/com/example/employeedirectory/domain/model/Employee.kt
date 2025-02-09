package com.example.employeedirectory.domain.model

data class Employee(
    val uuid: String? = null,
    val fullName: String? = null,
    val team: String? = null,
    val photoUrlSmall: String? = null,
    val photoUrlLarge: String? = null
)
