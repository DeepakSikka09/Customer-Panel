package com.ecomexpress.customerpanel.ui.event

import com.ecomexpress.customerpanel.data.response.OrderFilterModel
import com.ecomexpress.customerpanel.data.response.OrderTypeModel
import com.ecomexpress.customerpanel.utils.enums.OrderType

sealed class OrderEvent
{
    data class OnOrderChange(val orderType: OrderType):OrderEvent()
    object OnCloseFilter:OrderEvent()
    data class OnCheckboxClick(val value: OrderFilterModel):OrderEvent()
    object ApplyFilter:OrderEvent()
    data class onAwbClicked(val value: OrderTypeModel=OrderTypeModel(), val isChecked:Boolean=false, val isCheckedAll:Boolean=false,val isUncheckedAll:Boolean=false):OrderEvent()
}
