package com.ecomexpress.customerpanel.data.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserProfile(
    @PrimaryKey
    var employeeCode: String="",
    var userName: String= "",
    var shipperCode: String="",
)

