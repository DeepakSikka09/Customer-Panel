package com.ecomexpress.customerpanel.data.local.db.entities

import androidx.annotation.DrawableRes
import com.ecomexpress.customerpanel.R
import com.ecomexpress.customerpanel.utils.enums.ScreenEnum


data class ProfileData(@DrawableRes var leadingIcon:Int,
@DrawableRes var laggingIcon:Int,var phoneNumber:String,var description:String,var screen:String="")

var listOfProfileItem = listOf(
    ProfileData(R.drawable.ic_mobile,R.drawable.right_face_arrow,"9876543210","Change Mobile Number"),
    ProfileData(R.drawable.ic_email,R.drawable.right_face_arrow,"sandeep.singh@gmail.com","Change Email Address"),

    ProfileData(R.drawable.change_password,R.drawable.right_face_arrow,"Change Password","Change your password"),
    ProfileData(R.drawable.ic_logout,R.drawable.right_face_arrow,"Logout","Logout from Application", ScreenEnum.Login.name),

)
var listOfMoreOptions= listOf( ProfileData(R.drawable.training,R.drawable.right_face_arrow,"Training & Docs","Learning Videos & Documnets "),
    ProfileData(R.drawable.pincode_coverage,R.drawable.right_face_arrow,"Pincode Coverage","Delivery Service Location",
        ScreenEnum.PinCodeSearch.name),
    ProfileData(R.drawable.calculator,R.drawable.right_face_arrow,"Rate Calculator","Shipping Cost Calculator", ScreenEnum.RateCalculator.name),
)