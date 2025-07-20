package com.ecomexpress.customerpanel.ui.state

import com.ecomexpress.customerpanel.data.response.ActionPendingModel
import com.ecomexpress.customerpanel.data.response.ActionTakenModel
import com.ecomexpress.customerpanel.data.response.DeliveredModel
import com.ecomexpress.customerpanel.data.response.RtoModel
import com.ecomexpress.customerpanel.utils.enums.NdrTypeEnum

data class NdrState(
    var actionPendingList:ArrayList<ActionPendingModel> = arrayListOf(),
    var actionTakenList:ArrayList<ActionTakenModel> = arrayListOf(),
    var deliveredList:ArrayList<DeliveredModel> = arrayListOf(),
    var rtoList:ArrayList<RtoModel> = arrayListOf(),
    var selectedNdrTypeEnum: NdrTypeEnum = NdrTypeEnum.Action_Pending
)