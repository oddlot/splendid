package io.oddlot.splendid.data

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.room.*
import io.oddlot.splendid.utils.toDateString
//import io.oddlot.splendid.helpers.toDateString
import kotlin.math.round

@Entity(
    tableName = "item",
    foreignKeys = [
        ForeignKey(entity = Tab::class, parentColumns = ["id"], childColumns = ["tabId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val tabId: Int,
    var amount: Double,
    var description: String? = null,
    var date: Long = System.currentTimeMillis(),
    var isPayment: Boolean = false,
    var attachments: MutableList<Uri>? = null
) : Comparable<Transaction> {

    override fun compareTo(other: Transaction): Int {
//        val timeDelta = round((this.date - other.date) / 10000.0)
//
//        return if (this.pinned && !other.pinned) { // only this pinned
//            1
//        } else if (!this.pinned && other.pinned) { // only other pinned
//            -1
//        } else {
//            when (timeDelta) {
//                in 1 .. Int.MAX_VALUE -> 1 // true if this transaction's value is greater than the other
//                in 0 .. 0 -> if (this.id!! > other.id!!) 1 else -1
//                else -> -1
//            }
//        }
        return 1
    }

    override fun toString(): String {
        val formattedDate = this.date.toDateString()
        val formattedAmount = this.amount.toString()

        return "$formattedDate: $formattedAmount \n${this.description} ${this.attachments}"
    }
}

@Dao
interface TransactionDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Transaction>

    @Query("SELECT * FROM item")
    fun getAllAsLiveData(): LiveData<List<Transaction>>

    @Query("SELECT * FROM item WHERE id = :txnId")
    fun get(txnId: Int): Transaction

    @Query("SELECT * FROM item WHERE tabId = :tabId")
    fun getTransactionsByTabId(tabId: Int): List<Transaction>

    @Query("DELETE FROM item WHERE id = :itemId")
    fun deleteItemById(itemId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(transaction: Transaction): Long
}