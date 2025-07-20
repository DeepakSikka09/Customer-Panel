package com.ecomexpress.customerpanel.ui.event

import com.ecomexpress.customerpanel.utils.enums.NdrTypeEnum

sealed class NdrEvent{
    data class OnNdrChange(val ndrType: NdrTypeEnum):NdrEvent()
}