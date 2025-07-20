package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RateCalculatorViewModel : ViewModel(){

    private val _originPincode = MutableStateFlow("")
    private val _destinationPincode  = MutableStateFlow("")

    private val _kgCount= MutableStateFlow("0")
    private val _gramCount = MutableStateFlow("100")

    val kgCount: StateFlow<String> get() = _kgCount
    val gramCount: StateFlow<String> get() = _gramCount

    val originPincode: StateFlow<String> get() = _originPincode
    val destinationPincode: StateFlow<String> get() = _destinationPincode


    fun setOriginPincode(originPincode: String) {
        _originPincode.value = originPincode
    }

    fun setDestinationPincode(destinationPincode : String){
        _destinationPincode.value = destinationPincode
    }

    private val _productType = MutableStateFlow("")
    private val _collectableValues  = MutableStateFlow("")

    val productType: StateFlow<String> get() = _productType
    val collectableValues: StateFlow<String> get() = _collectableValues


    fun setProductType(productType: String) {
        _productType.value = productType
    }

    fun setCollectableValue(collectableValues : String){
        _collectableValues.value = collectableValues
    }

    fun setKgCount(kg: Int) {
        _kgCount.value=_kgCount.value.toInt().plus(kg).toString()

        if (_kgCount.value.toInt()<0){
            _kgCount.value="0"
        }
    }

    fun setGramCount(gram : Int){
        _gramCount.value=_gramCount.value.toInt().plus(gram).toString()

        if (_gramCount.value.toInt()<100){
            _gramCount.value="100"
        }
    }

}