package com.ecomexpress.customerpanel.data.local.db.entities



data class DateOptionItem(val date: String, val label: String)

var listofOptionsItem = listOf(
    DateOptionItem("21 May", "Today"),
    DateOptionItem("22 May", "Tomorrow"),
    DateOptionItem("23 Jun", "Friday"),
    DateOptionItem("24 Jun", "Saturday"),
    DateOptionItem("25 Jun", "Sunday"),
    DateOptionItem("26 Jun", "Monday"),
    DateOptionItem("27 Jun", "Tuesday")

)