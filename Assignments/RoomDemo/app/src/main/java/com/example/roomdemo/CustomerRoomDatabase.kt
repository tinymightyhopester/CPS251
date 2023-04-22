package com.example.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Customer::class)], version = 1)
abstract class CustomerRoomDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDAO

    companion object {

        private var INSTANCE: CustomerRoomDatabase? = null

        internal fun getDatabase(context: Context): CustomerRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(CustomerRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder<CustomerRoomDatabase>(
                                context.applicationContext,
                                CustomerRoomDatabase::class.java,
                                "customer_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}