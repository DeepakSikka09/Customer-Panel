package com.ecomexpress.customerpanel.data.response

data class ShipmentItem(
    val itemName: String = "",
    val category: String = "",
    val weight: String = "",
    val quantity: String = "",
    val isEssentialGoods: Boolean = false,
    val isDangerousGood: Boolean = false
)
