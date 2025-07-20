package com.ecomexpress.customerpanel.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ecomexpress.customerpanel.data.local.db.dao.ProfileDao
import com.ecomexpress.customerpanel.data.local.db.entities.UserProfile


@Database(entities = [UserProfile::class], version = 1, exportSchema = false)
abstract class CustomerPanelDatabase : RoomDatabase() {
     abstract fun profileDao(): ProfileDao
}
