package com.example.employeedirectory.data.model

import com.example.employeedirectory.domain.model.Employee
import com.google.gson.annotations.SerializedName

data class ApiEmployee(

    @SerializedName("uuid")
    val uuid: String? = null,

    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("email_address")
    val emailAddress: String? = null,

    @SerializedName("team")
    val team: String? = null,

    @SerializedName("employee_type")
    val employeeType: String? = null,

    @SerializedName("phone_number")
    val phoneNumber: String? = null,

    @SerializedName("biography")
    val biography: String? = null,

    @SerializedName("photo_url_small")
    val photoUrlSmall: String? = null,

    @SerializedName("photo_url_large")
    val photoUrlLarge: String? = null
) {
    companion object {
        fun toDomainEmployee(apiEmployee: ApiEmployee): Employee {
            return Employee(
                uuid = apiEmployee.uuid,
                fullName = apiEmployee.fullName,
                team = apiEmployee.team,
                photoUrlSmall = apiEmployee.photoUrlSmall,
                photoUrlLarge = apiEmployee.photoUrlLarge
            )
        }
    }
}