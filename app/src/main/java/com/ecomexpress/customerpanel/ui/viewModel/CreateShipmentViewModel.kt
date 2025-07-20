package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ecomexpress.customerpanel.data.response.ShipmentItem
import com.ecomexpress.customerpanel.ui.event.CreateShipmentEvent
import com.ecomexpress.customerpanel.ui.state.CreateShipmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateShipmentViewModel : ViewModel() {

    private val _state = MutableStateFlow(CreateShipmentState())
    val state: StateFlow<CreateShipmentState> get() = _state
    private val _searchText = MutableStateFlow("")

    // Convert searchText to read-only Flow
    val searchText: StateFlow<String> get() = _searchText

    private val _showDeliveryAddressData = MutableStateFlow(false)
    val showDeliveryAddress: StateFlow<Boolean> get() = _showDeliveryAddressData

    private val _showPickAddressData = MutableStateFlow(false)
    val showPickUpAddress: StateFlow<Boolean> get() = _showPickAddressData

    private val _searchAddress = MutableStateFlow("")
    val searchAddress: StateFlow<String> get() = _searchAddress

    private val _comeFromPickUp = MutableStateFlow(false)
    val comeFromPickUp: StateFlow<Boolean> get() = _comeFromPickUp

    private val _comeFromDelivery = MutableStateFlow(false)
    val comeFromDelivery: StateFlow<Boolean> get() = _comeFromDelivery

    private val _searchItem = MutableStateFlow("")
    val searchItemText: StateFlow<String> get() = _searchItem

    private val _searchPackage = MutableStateFlow("")
    val searchPackage: StateFlow<String> get() = _searchPackage

    private val _declareValue = MutableStateFlow("")
    val declareValue: StateFlow<String> get() = _declareValue

    private val _showSearchItem = MutableStateFlow(false)
    val showSearchItem: StateFlow<Boolean> get() = _showSearchItem

    private val _showPackageItem = MutableStateFlow(false)
    val showPackageItem: StateFlow<Boolean> get() = _showPackageItem

    private val _comeFromSearchItem = MutableStateFlow(false)
    val comeFromSearchItem: StateFlow<Boolean> get() = _comeFromSearchItem

    private val _comeFromPackageItem = MutableStateFlow(false)
    val comeFromPackageItem: StateFlow<Boolean> get() = _comeFromPackageItem

    private val _showPickUpMobile = MutableStateFlow(false)
    val showPickupMobile: StateFlow<Boolean> get() = _showPickUpMobile

    private val _showDeliveryMobile = MutableStateFlow(false)
    val showDeliveryMobile: StateFlow<Boolean> get() = _showDeliveryMobile


    private val _itemCount= MutableStateFlow(0)

    val itemCount: StateFlow<Int> get() = _itemCount
    // Function to update the searchText value
    fun setSearchText(newText: String) {
        _searchText.value = newText
    }

    fun setSearchItem(newText: String) {
        _searchItem.value = newText
    }

    fun setSearchPackage(newText: String) {
        _searchPackage.value = newText
    }


    // Convert searchText to read-only Flow

    // Function to update the searchText value
    fun setSearchAddress(newText: String) {
        _searchAddress.value = newText
    }


    // Convert searchText to read-only Flow


    // Function to update the searchText value
    fun showPickUpAddress(toShow: Boolean) {
        _showPickAddressData.value = toShow
    }


    // Convert searchText to read-only Flow


    // Function to update the searchText value
    fun showDeliveryAddress(toShow: Boolean) {
        _showDeliveryAddressData.value = toShow
    }
    fun showSearchItem(toShow: Boolean) {
        _showSearchItem.value = toShow
    }

    fun showPackageItem(toShow: Boolean) {
        _showPackageItem.value = toShow
    }

    fun setSearchItem(toShow: Boolean) {
        _comeFromSearchItem.value = toShow
    }
    fun setPackgeItem(toShow: Boolean) {
        _comeFromPackageItem.value = toShow
    }

    fun setPickUp(toShow: Boolean) {
        _comeFromPickUp.value = toShow
    }

    fun setCount(count: Int) {
        _itemCount.value=_itemCount.value.plus(count)

        if (_itemCount.value.toInt()<0){
            _itemCount.value=0
        }
    }



    // Convert searchText to read-only Flow


    // Function to update the searchText value
    fun setDelivery(toShow: Boolean) {
        _comeFromDelivery.value = toShow
    }

    fun setDeclareValue(declareValue: String) {
        _declareValue.value = declareValue
    }

    fun setPickupMobile(toShow: Boolean) {
        _showPickUpMobile.value = toShow
    }

    fun setDeliveryMobile(toShow: Boolean) {
        _showDeliveryMobile.value = toShow
    }





    fun onEvent(event: CreateShipmentEvent) {
        when (event) {
            is CreateShipmentEvent.Address1Changed -> {
                _state.value = _state.value.copy(
                    address1 = event.address1
                )
                validateConsigneeDetail()
            }

            is CreateShipmentEvent.CityChanged -> {
                _state.value = _state.value.copy(
                    city = event.city
                )
                validateConsigneeDetail()
            }

            is CreateShipmentEvent.StateChanged -> {
                _state.value = _state.value.copy(
                    state = event.state
                )
                validateConsigneeDetail()
            }


            is CreateShipmentEvent.Address2Changed -> {
                _state.value = _state.value.copy(
                    address2 = event.address2
                )
                validateConsigneeDetail()
            }

            is CreateShipmentEvent.AltMobileChanged -> {
                _state.value = _state.value.copy(
                    altMobile = event.altMobile
                )
            }

            is CreateShipmentEvent.LandMarkChanged -> {
                _state.value = _state.value.copy(
                    landmark = event.landmark
                )
                validateConsigneeDetail()
            }

            is CreateShipmentEvent.MobileChanged -> {
                _state.value = _state.value.copy(
                    mobile = event.mobile
                )
                validateConsigneeDetail()
            }

            is CreateShipmentEvent.NameChanged -> {
                _state.value = _state.value.copy(
                    name = event.name
                )
                validateConsigneeDetail()
            }

            is CreateShipmentEvent.PincodeChanged -> {
                _state.value = _state.value.copy(
                    pincode = event.pincode
                )
                validateConsigneeDetail()
            }

            CreateShipmentEvent.AltMobileExpand -> {
                _state.value = _state.value.copy(
                    altNumberExpand = (!_state.value.altNumberExpand)
                )
            }

            CreateShipmentEvent.ConsigneeExpand -> {
                _state.value = _state.value.copy(
                    consigneeExpand = (!_state.value.consigneeExpand),
                )
            }

            CreateShipmentEvent.OrderExpand -> {
                if (_state.value.formFilled >= 1) {
                    _state.value = _state.value.copy(
                        orderExpand = (!_state.value.orderExpand),
                    )
                }
            }

            CreateShipmentEvent.PickupExpand -> {
                if (_state.value.formFilled >= 2) {
                    _state.value = _state.value.copy(
                        pickupExpand = (!_state.value.pickupExpand),
                    )
                }
            }

            CreateShipmentEvent.ShipmentExpand -> {
                if (_state.value.formFilled >= 3) {
                    _state.value = _state.value.copy(
                        shipmentExpand = (!_state.value.shipmentExpand),
                    )
                }
            }

            is CreateShipmentEvent.PaymentTypeChange -> {
                _state.value = _state.value.copy(
                    paymentType = event.type
                )
                validateOrders()
            }

            is CreateShipmentEvent.CollectableValueChange -> {
                _state.value = _state.value.copy(
                    collectableValue = event.value
                )
                validateOrders()
            }

            is CreateShipmentEvent.DeclaredValueChange -> {
                _state.value = _state.value.copy(
                    declaredValue = event.value
                )
                validateOrders()
            }

            is CreateShipmentEvent.InvoiceDateChange -> {
                _state.value = _state.value.copy(
                    invoiceDate = event.value
                )
                validateOrders()
            }

            is CreateShipmentEvent.InvoiceNumberChange -> {
                _state.value = _state.value.copy(
                    invoiceNumber = event.value
                )
                validateOrders()
            }

            is CreateShipmentEvent.OrderNumberChange -> {
                _state.value = _state.value.copy(
                    orderNumber = event.value
                )
                validateOrders()
            }

            is CreateShipmentEvent.PickupAddressChange -> {
                _state.value = _state.value.copy(
                    pickupAddress = event.value
                )
                validatePickupReturn()
            }

            is CreateShipmentEvent.PickupAltMobileChange -> {
                _state.value = _state.value.copy(
                    pickupAltMobile = event.value
                )
                validatePickupReturn()
            }

            is CreateShipmentEvent.PickupLocationTypeChange -> {
                _state.value = _state.value.copy(
                    pickupLocationType = event.value
                )
                validatePickupReturn()
            }

            is CreateShipmentEvent.PickupMobileChange -> {
                _state.value = _state.value.copy(
                    pickupMobile = event.value
                )
                validatePickupReturn()
            }

            is CreateShipmentEvent.PickupNameChange -> {
                _state.value = _state.value.copy(
                    pickupName = event.value
                )
                validatePickupReturn()
            }

            is CreateShipmentEvent.PickupPinCodeChange -> {
                _state.value = _state.value.copy(
                    pickupPincode = event.value
                )
                validatePickupReturn()
            }

            CreateShipmentEvent.PickupALtMobileExpand -> {
                _state.value = _state.value.copy(
                    pickAltMobileExpand = (!_state.value.pickAltMobileExpand)
                )
            }

            CreateShipmentEvent.PickupReturnSwitch -> {
                _state.value = _state.value.copy(
                    isPickReturnSame = (!_state.value.isPickReturnSame)
                )
            }

            is CreateShipmentEvent.BreadthChange -> {
                _state.value = _state.value.copy(
                    breadth = event.value
                )
                validateShipment()
            }

            is CreateShipmentEvent.HeightChange -> {
                _state.value = _state.value.copy(
                    height = event.value
                )
                validateShipment()
            }

            is CreateShipmentEvent.LengthChange -> {
                _state.value = _state.value.copy(
                    length = event.value
                )
                validateShipment()
            }

            is CreateShipmentEvent.PackagingTypeChange -> {
                _state.value = _state.value.copy(
                    packagingType = event.value
                )
                validateShipment()
            }

            is CreateShipmentEvent.PackagingNameChanged -> {
                _state.value = _state.value.copy(
                    packagingName = event.packagingName
                )
               // validateShipment()
            }

            is CreateShipmentEvent.PackagingUsedChange -> {
                _state.value = _state.value.copy(
                    packagingUsed = event.value
                )
                validateShipment()
            }

            is CreateShipmentEvent.VolWeightChange -> {
                _state.value = _state.value.copy(
                    volWeight = event.value
                )
                validateShipment()
            }

            is CreateShipmentEvent.WeightChange -> {
                _state.value = _state.value.copy(
                    weight = event.value
                )
                validateShipment()
            }

            CreateShipmentEvent.NewItemAdd -> {
                _state.value.let {
                    val list = it.itemList.toMutableList()
                    list.add(it.newItem)
                    _state.value = it.copy(
                        itemList = list,
                        newItem = ShipmentItem(),
                        newItemAddEnable = false
                    )
                }
            }

            is CreateShipmentEvent.NewItemCategoryChange -> {
                _state.value.let {
                    _state.value = it.copy(
                        newItem = it.newItem.copy(
                            category = event.value
                        )
                    )
                    newItemValidate()
                }
            }

            CreateShipmentEvent.NewItemClose -> {
                _state.value = _state.value.copy(
                    newItem = ShipmentItem()
                )
            }

            CreateShipmentEvent.NewItemIsDangerous -> {
                _state.value.let {
                    _state.value = it.copy(
                        newItem = it.newItem.copy(
                            isDangerousGood = !it.newItem.isDangerousGood
                        )
                    )
                    newItemValidate()
                }
            }

            CreateShipmentEvent.NewItemIsEssential -> {
                _state.value.let {
                    _state.value = it.copy(
                        newItem = it.newItem.copy(
                            isEssentialGoods = !it.newItem.isEssentialGoods
                        )
                    )
                    newItemValidate()
                }
            }

            is CreateShipmentEvent.NewItemNameChange -> {
                _state.value.let {
                    _state.value = it.copy(
                        newItem = it.newItem.copy(
                            itemName = event.value
                        )
                    )
                    newItemValidate()
                }
            }

            is CreateShipmentEvent.NewItemQuantityChange -> {
                _state.value.let {
                    _state.value = it.copy(
                        newItem = it.newItem.copy(
                            quantity = event.value
                        )
                    )
                    newItemValidate()
                }
            }

            is CreateShipmentEvent.NewItemWeightChange -> {
                _state.value.let {
                    _state.value = it.copy(
                        newItem = it.newItem.copy(
                            weight = event.value
                        )
                    )
                    newItemValidate()
                }
            }

            is CreateShipmentEvent.DeleteItem ->{
                _state.value.let {
                    val list = it.itemList.toMutableList()
                    list.remove(event.value)
                    _state.value = it.copy(
                        itemList = list,
                    )
                }
            }
            is CreateShipmentEvent.ClearAll -> {
                _state.value = CreateShipmentState()
            }

            //
            is CreateShipmentEvent.SellerGSTNChanged -> {
                _state.value = _state.value.copy(
                    sellerGST = event.sellerGSTN
                )
                //validateConsigneeDetail()
            }

            is CreateShipmentEvent.EwayBillChanged -> {
                _state.value = _state.value.copy(
                    eWayBill = event.ewayBill
                )
                //validateConsigneeDetail()
            }

            is CreateShipmentEvent.TotalItemValueChanged -> {
                _state.value = _state.value.copy(
                    totalItemValue = event.totalItemValue
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.SGSTAmtChanged -> {
                _state.value = _state.value.copy(
                    sgstAmt = event.sgstAmt
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.CGSTAmtChanged -> {
                _state.value = _state.value.copy(
                    cgstAmt = event.cgstAmt
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.IGSTAmtChanged -> {
                _state.value = _state.value.copy(
                    igstAmt = event.igstAmt
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.TotalGSTAmtChanged -> {
                _state.value = _state.value.copy(
                    totalgstAmt = event.totalGSTAmt
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.TotalInvoiceValueChanged -> {
                _state.value = _state.value.copy(
                    totalinvoiceValue = event.totalInvoiceValue
                )
                //validateConsigneeDetail()
            }

            is CreateShipmentEvent.ReferenceIdChanged -> {
                _state.value = _state.value.copy(
                    referenceId = event.referenceId
                )
                //validateConsigneeDetail()
            }

            is CreateShipmentEvent.ItemCategoryChanged -> {
                _state.value = _state.value.copy(
                    itemCategory = event.itemCategory
                )
                //validateConsigneeDetail()
            }

            is CreateShipmentEvent.ItemNameChanged -> {
                _state.value = _state.value.copy(
                    itemName = event.itemName
                )
                //validateConsigneeDetail()
            }

            is CreateShipmentEvent.ItemDescriptionChanged -> {
                _state.value = _state.value.copy(
                    itemDescription = event.itemDescription
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.HSNCodeChanged -> {
                _state.value = _state.value.copy(
                    HSNCode = event.hsnCode
                )
                //validateConsigneeDetail()
            }
            is CreateShipmentEvent.DeadWeightChanged -> {
                _state.value = _state.value.copy(
                    deadWeight = event.deadWeight
                )
                //validateConsigneeDetail()
            }


        }
    }

    fun validateConsigneeDetail() {
        _state.value.let {
            if (
               /* it.mobile.length == 10 &&
                it.pincode.length == 6 &&
                it.name.isNotEmpty() &&*/
                it.address1.isNotEmpty() &&
                it.address2.isNotEmpty()  /*&&
               it.landmark.isNotEmpty()*/
            ) {
                _state.value = it.copy(
                    formFilled = 1,
                    orderExpand = true
                )
                validateOrders()
            } else {
                _state.value = it.copy(
                    formFilled = 0,
                    orderExpand = false,
                    pickupExpand = false,
                    shipmentExpand = false
                )
            }
        }
    }

    fun validateOrders() {
        _state.value.let { data ->
            if (
                data.orderNumber.isNotEmpty() &&
               // data.declaredValue.isNotEmpty() &&
               // data.collectableValue.isNotEmpty() &&
                data.invoiceNumber.isNotEmpty() &&
                data.invoiceDate.length == 8
            ) {
                _state.value = data.copy(
                    formFilled = 2,
                    pickupExpand = true
                )
                validatePickupReturn()
            } else {
                _state.value = data.copy(
                    formFilled = 1,
                    pickupExpand = false,
                    shipmentExpand = false
                )
            }
        }
    }

    fun validatePickupReturn() {
        _state.value.let { data ->
            if (
                data.paymentType==0 || data.paymentType==1
                /*data.pickupAddress.isNotEmpty() &&
                data.pickupMobile.length == 10 &&
                data.pickupName.isNotEmpty() &&
                data.pickupPincode.length == 6 &&
                data.pickupLocationType.isNotEmpty()*/
            ) {
                _state.value = data.copy(
                    formFilled = 3,
                    shipmentExpand = true
                )
            } else {
                _state.value = data.copy(
                    formFilled = 2,
                    shipmentExpand = false
                )
            }
        }
    }

    fun validateShipment() {
        _state.value.let {
            if (
                it.itemList.isNotEmpty() &&
                it.packagingType.isNotEmpty() &&
                it.packagingUsed.isNotEmpty() &&
                it.length.isNotEmpty() &&
                it.breadth.isNotEmpty() &&
                it.height.isNotEmpty() &&
                it.weight.isNotEmpty() &&
                it.volWeight.isNotEmpty()
            ) {
                _state.value = it.copy(
                    submitEnable = true
                )
            } else {
                _state.value = it.copy(
                    submitEnable = false
                )
            }
        }
    }

    fun newItemValidate() {
        _state.value.newItem.let {
            if (
                it.itemName.isNotEmpty() &&
                it.weight.isNotEmpty() &&
                it.category.isNotEmpty() &&
                it.quantity.isNotEmpty()
            ){
                _state.value = _state.value.copy(
                    newItemAddEnable = true
                )
            }else{
                _state.value = _state.value.copy(
                    newItemAddEnable = false
                )
            }
        }
    }
}