package io.oddlot.splendid.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Tab::class, Transaction::class, Member::class, Membership::class], version = 1)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tabDao(): TabDao
    abstract fun transactionDao(): TransactionDao
    abstract fun memberDao(): MemberDao
    abstract fun membershipDao(): MembershipDao

    companion object {
//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE item ADD attachedImages TEXT")
//            }
//        }
    }
}