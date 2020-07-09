//package com.example.cloneshopee.home.displayHistory
//
//import androidx.room.*
//
//@Dao
//interface BillDAO {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertBill(billModel: BillModel): Long
//
//    @Update
//    fun updateBill(billModel: BillModel)
//
//    @Query("SELECT * from bill_history WHERE current_user = :user")
//    fun getBill(user: String): BillModel
//}