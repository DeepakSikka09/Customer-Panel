package com.ecomexpress.customerpanel.data.response

import com.ecomexpress.customerpanel.utils.enums.OrderType

data class OrderTypeModel(
    val awbNo: Long=0,
    val orderDate:String="",
    val productType:String="",
    val status:String="",
    val orderType:OrderType=OrderType.BOTH,
    var isChecked:Boolean=false
)
