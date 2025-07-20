package com.ecomexpress.customerpanel.ui.state

import com.ecomexpress.customerpanel.data.response.ShipmentItem

data class CreateShipmentState(
    var formFilled: Int = 0,
    var consigneeExpand: Boolean = true,
    var orderExpand: Boolean = false,
    var pickupExpand: Boolean = false,
    var shipmentExpand: Boolean = false,

    var mobile: String = "",
    var name: String = "",
    var address1: String = "",
    var address2: String = "",
    var city: String = "",
    var state: String = "",
    var landmark: String = "",
    var pincode: String = "",
    var altMobile: String = "",
    var altNumberExpand: Boolean = false,

    var paymentType: Int = 0,
    var orderNumber: String = "",
    var declaredValue: String = "",
    var collectableValue: String = "",
    var invoiceNumber: String = "",
    var invoiceDate: String = "",

    var pickupName: String = "",
    var pickupAddress: String = "",
    var pickupPincode: String = "",
    var pickupLocationType: String = "",
    var pickupMobile: String = "",
    var pickupAltMobile: String = "",
    var pickAltMobileExpand:Boolean = false,
    var isPickReturnSame:Boolean = true,

    var itemList:List<ShipmentItem> = mutableListOf(),
    var packagingUsed:String = "",
    var packagingType:String = "",
    var packagingName:String = "",
    var length:String = "",
    var breadth:String = "",
    var height:String = "",
    var weight:String = "",
    var volWeight:String = "",
    var submitEnable:Boolean = false,
    var newItem: ShipmentItem = ShipmentItem(),
    var newItemAddEnable:Boolean = false,

    //
    var sellerGST: String = "",
    var eWayBill: String = "",
    var totalItemValue: String = "",
    var sgstAmt: String = "",
    var cgstAmt: String = "",
    var igstAmt: String = "",
    var totalgstAmt: String = "",
    var totalinvoiceValue: String = "",


    var referenceId: String = "",
    var itemCategory: String = "",
    var itemName: String = "",
    var itemDescription: String = "",
    var HSNCode: String = "",
    var deadWeight: String = "",




    )
