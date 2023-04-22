package com.example.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CustomerDAO {

    @Query("SELECT * FROM customers")
    fun getAllCustomers(): LiveData<List<Customer>>

    @Query("SELECT * FROM customers WHERE customerName = :name")
    fun findCustomer(name: String): List<Customer>

    @Insert
    fun addCustomer(customer: Customer)

    @Query("DELETE FROM customers WHERE customerName = :name")
    fun deleteCustomer(name: String)

}