package com.example.roomdemo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class CustomerRepository(application: Application) {

    val searchResults = MutableLiveData<List<Customer>>()
    private var customerDao: CustomerDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allCustomers: LiveData<List<Customer>>?

    init {
        val db: CustomerRoomDatabase? =
            CustomerRoomDatabase.getDatabase(application)
        customerDao = db?.customerDao()
        allCustomers = customerDao?.getAllCustomers()
    }

    fun addCustomer(newcustomer: Customer) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcustomer)
        }
    }
    private suspend fun asyncInsert(customer: Customer) {
        customerDao?.addCustomer(customer)
    }
    fun deleteCustomer(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }
    private suspend fun asyncDelete(name: String) {
        customerDao?.deleteCustomer(name)
    }
    fun findCustomer(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private suspend fun asyncFind(name: String): Deferred<List<Customer>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async customerDao?.findCustomer(name)
        }

}