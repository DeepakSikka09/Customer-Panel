package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ecomexpress.customerpanel.data.response.OrderFilterModel
import com.ecomexpress.customerpanel.data.response.OrderTypeModel
import com.ecomexpress.customerpanel.ui.event.OrderEvent
import com.ecomexpress.customerpanel.ui.state.OrderState
import com.ecomexpress.customerpanel.utils.enums.OrderFilterTypeEnum
import com.ecomexpress.customerpanel.utils.enums.OrderType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OrderViewModel : ViewModel() {

    val filterValue = arrayListOf(
        OrderFilterModel(
            filter = "Manifested",
            orderType = OrderType.BOTH,
            filterType = OrderFilterTypeEnum.Manifested
        ),
        OrderFilterModel(
            filter = "Out For Pickup",
            orderType = OrderType.REVERSE,
            filterType = OrderFilterTypeEnum.Out_For_Pickup
        ),
        OrderFilterModel(
            filter = "Picked Up",
            orderType = OrderType.BOTH,
            filterType = OrderFilterTypeEnum.Picked_Up
        ),
        OrderFilterModel(
            filter = "In Transit",
            orderType = OrderType.FORWARD,
            filterType = OrderFilterTypeEnum.IN_Transit
        ),
        OrderFilterModel(
            filter = "Out For Delivery",
            orderType = OrderType.FORWARD,
            filterType = OrderFilterTypeEnum.Out_For_Delivery
        ),
        OrderFilterModel(
            filter = "Delivered",
            orderType = OrderType.BOTH,
            filterType = OrderFilterTypeEnum.Delivered
        ),
        OrderFilterModel(
            filter = "Return To Seller",
            orderType = OrderType.FORWARD,
            filterType = OrderFilterTypeEnum.Return_To_Seller
        ),
        OrderFilterModel(
            filter = "QC Manifested",
            orderType = OrderType.REVERSE,
            filterType = OrderFilterTypeEnum.QC_Manifested
        ),

        )
    private val _currentState = MutableStateFlow(OrderState())
    val currentState: StateFlow<OrderState> get() = _currentState

    private val _isCheckedAll= MutableStateFlow(false)
    val isCheckdAll:StateFlow<Boolean> get() = _isCheckedAll

    private val _filterCount = MutableStateFlow(0)
    val filterCount: StateFlow<Int> get() = _filterCount


    init {
        setData()
    }


     fun setFilterCount(count: Int) {
        _filterCount.value=_filterCount.value.plus(count)
        if (_filterCount.value < 0) {
            _filterCount.value = 0
        }
    }
     fun checkedFilter(isChecked: Boolean){
        _isCheckedAll.value=isChecked
    }

    fun setData(isChecked: Boolean=false){
        _currentState.value =
            OrderState(
            orderList = arrayListOf(
                OrderTypeModel(
                    2309680899, "23-04-2002", "PPD", "Outscan", OrderType.FORWARD, isChecked = isChecked
                ),
                OrderTypeModel(
                    23096806915, "23-04-2002", "PPD", "Network Delay", OrderType.FORWARD,isChecked = isChecked
                ),
                OrderTypeModel(
                    23096062113, "23-04-2002", "COD", "Outscan", OrderType.FORWARD,isChecked = isChecked
                ),
                OrderTypeModel(
                    2309680110, "23-04-2002", "PPD", "Outscan", OrderType.FORWARD,isChecked = isChecked
                ),
                OrderTypeModel(
                    2309686925, "23-04-2002", "PPD", "Outscan", OrderType.FORWARD,isChecked = isChecked
                ),
                OrderTypeModel(
                    2309680695, "23-04-2002", "PPD", "Network Delay", OrderType.REVERSE,isChecked = isChecked
                ),
                OrderTypeModel(
                    2096806935, "23-04-2002", "COD", "Outscan", OrderType.REVERSE,isChecked = isChecked
                ),
                OrderTypeModel(
                    23096806945, "23-04-2002", "COD", "Outscan", OrderType.REVERSE,isChecked = isChecked
                ),
            ),
            currentlySelectedFilter = setOf(),
            checkedFilterList = setOf(),
            currentOrderType = OrderType.FORWARD,
        )
    }

    fun onEvent(orderEvent: OrderEvent) {
        when (orderEvent) {
            is OrderEvent.OnOrderChange -> {
                _currentState.value = _currentState.value.copy(
                    currentOrderType = orderEvent.orderType,
                    checkedFilterList = setOf(),
                    currentlySelectedFilter = setOf(),
                )
            }

            OrderEvent.ApplyFilter -> {
                _currentState.value = _currentState.value.copy(
                    currentlySelectedFilter = _currentState.value.checkedFilterList
                )
            }

            is OrderEvent.OnCheckboxClick -> {
                val filters = _currentState.value.checkedFilterList.toMutableSet()
                // val orderList =_currentState.value.orderList.toMutableList()
                if (filters.contains(
                        orderEvent.value.filterType
                    )
                ) {
                    filters.remove(orderEvent.value.filterType)
                } else {
                    filters.add(orderEvent.value.filterType)
                }
                _currentState.value = _currentState.value.copy(
                    checkedFilterList = filters,
                )
            }

            OrderEvent.OnCloseFilter -> {
                if (_currentState.value.checkedFilterList.isEmpty()) {
                    _currentState.value =
                        _currentState.value.copy(currentlySelectedFilter = setOf())
                }
                val removeFilter =
                    _currentState.value.checkedFilterList.minus(_currentState.value.currentlySelectedFilter)
                val addFilter =
                    _currentState.value.currentlySelectedFilter.minus(_currentState.value.checkedFilterList)
                if (removeFilter.isNotEmpty()) {
                    val filters = _currentState.value.checkedFilterList.toMutableSet()
                    filters.removeAll(removeFilter)
                    _currentState.value = _currentState.value.copy(
                        checkedFilterList = filters
                    )
                }
                if (addFilter.isNotEmpty()) {
                    val filters = _currentState.value.checkedFilterList.toMutableSet()
                    filters.addAll(addFilter)
                    _currentState.value = _currentState.value.copy(
                        checkedFilterList = filters
                    )
                }
            }
            is OrderEvent.onAwbClicked -> {
                val newList: List<OrderTypeModel>
                if (orderEvent.isCheckedAll){
                     newList = _currentState.value.orderList.map {
                        it.copy(isChecked = true)

                    }
                    _filterCount.value=_currentState.value.orderList.size

                }else if (orderEvent.isUncheckedAll){
                    newList = _currentState.value.orderList.map {
                        it.copy(isChecked = false)
                    }
                    _filterCount.value=0
                }
                    else{

                     newList = _currentState.value.orderList.map { it ->
                        if (it.awbNo == orderEvent.value.awbNo) {
                            it.copy(isChecked = orderEvent.isChecked)

                        } else {
                            it
                        }
                    }
                    if (orderEvent.isChecked){
                        setFilterCount(1)
                    }else{
                        setFilterCount(-1)
                    }
                }



                _currentState.value = _currentState.value.copy(
                    orderList = newList as ArrayList<OrderTypeModel>
                )


            }
        }
    }
}
