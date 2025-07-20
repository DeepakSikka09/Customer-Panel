package com.ecomexpress.customerpanel.data.local.db.entities

import androidx.annotation.DrawableRes
import com.ecomexpress.customerpanel.R

data class WalletData(@DrawableRes var leadingIcon:Int, var shipmentCharge:String,var date:String, var rupees:String, var type:String, var awb:String)

var listOfWalletItem = listOf(
    WalletData(R.drawable.rsicon,"Wallet Recharge","25 May, 2023", rupees = "+ ₹780","plus", awb = "AWB: 1942298362"),
    WalletData(R.drawable.rsiconblack,"Shipment Charge","25 May, 2023", rupees = "- ₹180","minus", awb = "AWB: 1942298362"),
    WalletData(R.drawable.rsicon,"Wallet Recharge","25 May, 2023", rupees = "+ ₹480","plus", awb = "AWB: 1942298362"),
)