package com.example.roomdemo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(tableName = "customers")
class Customer {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "customerId")
    var id: Int = 0
    @ColumnInfo(name = "customerName")
    var name: String? = null
    @Ignore
    var address: String? = null

    constructor() {}

    constructor(id: Int, name: String, address: String) {
        this.id = id
        this.name = name
        this.address = address
    }

    constructor(name: String, address: String) {
        this.name = name
        this.address = address
    }

    @Entity(foreignKeys = arrayOf(ForeignKey(entity = Customer::class,
        parentColumns = arrayOf("customerId"),
        childColumns = arrayOf("buyerId"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.RESTRICT)))
    class Purchase {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "purchaseId")
        var purchaseId: Int = 0

        @ColumnInfo(name = "buyerId")
        var buyerId: Int = 0
    }
}