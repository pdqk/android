//package com.example.cloneshopee.home.displayHistory
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [BillModel::class], version = 1, exportSchema = false)
//abstract class BillDatabase: RoomDatabase() {
//    abstract val billDAO: BillDAO
//
//    companion object{
//        @Volatile
//        private var INSTANCE: BillDatabase? = null
//
//        fun getInstance(context: Context) : BillDatabase{
//            synchronized(this){
//                var instance = INSTANCE
//
//                if(instance == null){
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        BillDatabase::class.java,
//                        "bill_history"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//
//                return instance
//            }
//        }
//    }
//}