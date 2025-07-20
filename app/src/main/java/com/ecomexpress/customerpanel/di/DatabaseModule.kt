package com.ecomexpress.customerpanel.di

import android.content.Context
import androidx.room.Room
import com.ecomexpress.customerpanel.data.local.db.CustomerPanelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CustomerPanelDatabase {
        return Room.databaseBuilder(
            context,
            CustomerPanelDatabase::class.java,
            "customer_panel_database"
        ).fallbackToDestructiveMigration().build()
    }



}
