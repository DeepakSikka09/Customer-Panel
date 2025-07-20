package com.ecomexpress.customerpanel.data.response

import com.ecomexpress.customerpanel.utils.enums.OrderFilterTypeEnum
import com.ecomexpress.customerpanel.utils.enums.OrderType

data class OrderFilterModel(
    val filter:String,
    val orderType:OrderType,
    val filterType:OrderFilterTypeEnum
)
