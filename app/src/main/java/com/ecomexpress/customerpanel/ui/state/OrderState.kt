package com.ecomexpress.customerpanel.ui.state

import com.ecomexpress.customerpanel.data.response.OrderTypeModel
import com.ecomexpress.customerpanel.utils.enums.OrderFilterTypeEnum
import com.ecomexpress.customerpanel.utils.enums.OrderType

data class OrderState(
    var currentlySelectedFilter: Set<OrderFilterTypeEnum> = setOf(),
    var checkedFilterList: Set<OrderFilterTypeEnum> = setOf(),
    var currentOrderType: OrderType = OrderType.BOTH,
    var orderList:ArrayList<OrderTypeModel> = arrayListOf(),
)
