package com.ecomexpress.customerpanel.data.local.db.entities

import androidx.annotation.DrawableRes
import com.ecomexpress.customerpanel.R

data class OptionsData(@DrawableRes var leadingIcon:Int, var content:String,var description:String)

var listOfOptionsItem = listOf(
    OptionsData(R.drawable.offer,"500WALLET","GET ₹500 Bonus on ₹2000 wallet Recharge"),
    OptionsData(R.drawable.offer,"500WALLET","GET ₹500 Bonus on ₹2000 wallet Recharge"),
    OptionsData(R.drawable.offer,"500WALLET","GET ₹500 Bonus on ₹2000 wallet Recharge"),
)