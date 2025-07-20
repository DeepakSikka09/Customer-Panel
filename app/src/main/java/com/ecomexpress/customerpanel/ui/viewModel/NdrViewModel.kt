package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ecomexpress.customerpanel.data.response.ActionPendingModel
import com.ecomexpress.customerpanel.data.response.ActionTakenModel
import com.ecomexpress.customerpanel.data.response.DeliveredModel
import com.ecomexpress.customerpanel.data.response.RtoModel
import com.ecomexpress.customerpanel.ui.event.NdrEvent
import com.ecomexpress.customerpanel.ui.state.NdrState
import com.ecomexpress.customerpanel.utils.enums.NdrTypeEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NdrViewModel : ViewModel() {
    private val _ndrState = MutableStateFlow(NdrState())
    val ndrState: StateFlow<NdrState> get() = _ndrState

    private val _searchText = MutableStateFlow("")

    // Convert searchText to read-only Flow
    val searchText: StateFlow<String> get() = _searchText

    // Function to update the searchText value
    fun setSearchText(newText: String) {
        _searchText.value = newText
    }
    init {
        setData()
    }

    private fun setData() {
        _ndrState.value = NdrState(
            actionPendingList = arrayListOf(
                ActionPendingModel(
                    2920836071,
                    "28-05-2023",
                    "1",
                    "PPD"
                ),
                ActionPendingModel(
                    2920836069,
                    "23-05-2023",
                    "1",
                    "PPD"
                ),
                ActionPendingModel(
                    2920836043,
                    "13-05-2023",
                    "1",
                    "PPD"
                ),
                ActionPendingModel(
                    2920836023,
                    "05-05-2023",
                    "1",
                    "PPD"
                ),
                ActionPendingModel(
                    2920836034,
                    "26-05-2023",
                    "1",
                    "PPD"
                ),
                ActionPendingModel(
                    2920836074,
                    "28-05-2023",
                    "1",
                    "PPD"
                ),

                ),
            actionTakenList = arrayListOf(
                ActionTakenModel(
                    1942298365,
                    "15",
                    "21-05-2023",
                    1
                ),
                ActionTakenModel(
                    1942298321,
                    "15",
                    "23-05-2023",
                    5
                ),
                ActionTakenModel(
                    1942298389,
                    "15",
                    "21-06-2023",
                    3
                ),
                ActionTakenModel(
                    1942298255,
                    "15",
                    "11-05-2023",
                    1
                ),
                ActionTakenModel(
                    1942298895,
                    "15",
                    "01-05-2023",
                    4
                ),
                ActionTakenModel(
                    1942298765,
                    "15",
                    "20-05-2023",
                    2
                ),
            ),
            deliveredList = arrayListOf(
                DeliveredModel(
                    2920836071,
                    "28-05-2023",
                    "Success",
                ),
                DeliveredModel(
                    2920836069,
                    "23-05-2023",
                    "Success"
                ),
                DeliveredModel(
                    2920836043,
                    "13-05-2023",
                    "Success"
                ),
                DeliveredModel(
                    2920836023,
                    "16-05-2023",
                    "Success"
                ),
                DeliveredModel(
                    2920836034,
                    "26-05-2023",
                    "Success"
                ),
                DeliveredModel(
                    2920836074,
                    "28-05-2023",
                    "Success"
                ),

                ),
            rtoList = arrayListOf(
                RtoModel(
                    2920836071,
                    "28-05-2023",
                    "Customer not in Residence",
                ),
                RtoModel(
                    2920836069,
                    "23-05-2023",
                    "Customer not in Residence",
                ),
            ),
            selectedNdrTypeEnum = NdrTypeEnum.Action_Pending
        )
    }

    fun onEvent(ndrEvent: NdrEvent) {
        when (ndrEvent) {
            is NdrEvent.OnNdrChange -> {
                _ndrState.value = _ndrState.value.copy(selectedNdrTypeEnum = ndrEvent.ndrType)
            }
        }
    }
}