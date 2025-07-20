package com.ecomexpress.customerpanel.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChangePasswordViewModel  : ViewModel(){

    // Create MutableStateFlow for username and password
    private val _newPassword = MutableStateFlow("")
    private val _confirmPassword = MutableStateFlow("")


    // Expose username and password as read-only StateFlow
    val newPassword: StateFlow<String> get() = _newPassword

    // Functions to update username and password values
    fun setNewPassword(newUsername: String) {
        _newPassword.value = newUsername
    }




    // Expose username and password as read-only StateFlow
    val confirmPassword: StateFlow<String> get() = _confirmPassword

    // Functions to update username and password values
    fun setConfirmPassword(newUsername: String) {
        _confirmPassword.value = newUsername
    }


}