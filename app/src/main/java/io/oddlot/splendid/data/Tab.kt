package io.oddlot.splendid.data

import androidx.lifecycle.LiveData
import androidx.room.*
//import io.oddlot.splendid.db
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Entity(
    tableName = "Tab",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class Tab (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var name: String,
    var owner: Member,
    var balance: Double = 0.0,
    var currency: String = "USD"
)

@Dao
interface TabDao {
    @Query("SELECT * FROM Tab ORDER BY name ASC")
    fun getAll(): List<Tab>

    @Query("SELECT * FROM Tab ORDER BY name ASC")
    fun getAllAsLiveData(): LiveData<List<Tab>>

    @Query("SELECT * FROM Tab WHERE id = :tabId")
    fun getTabById(tabId: Int): Tab

    @Query("SELECT * FROM Tab WHERE id = :tabId")
    fun getLiveTabById(tabId: Int): LiveData<Tab>

    @Query("SELECT * FROM Tab WHERE name = :tabName")
    fun getTabByName(tabName: String): Tab

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertTab(tab: Tab): Long

    @Query("DELETE FROM Tab WHERE id = :tabId")
    fun deleteTabById(tabId: Int): Int

    @Query("UPDATE Tab SET currency = :currency WHERE id = :tabId")
    fun setCurrency(tabId: Int, currency: String)

    @Update
    fun updateTab(tab: Tab)

    @Query("UPDATE Tab SET balance = :balance WHERE id = :tabId")
    fun updateTabBalance(tabId: Int, balance: Double)
}