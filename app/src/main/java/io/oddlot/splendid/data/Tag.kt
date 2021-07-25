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
    tableName = "Tag",
    indices = [
        Index(value = ["value"], unique = true)
    ]
)
data class Tag (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var value: String,
    var color: Int? = null,
)

@Dao
interface TagDao {
    @Query("SELECT * FROM Tag ORDER BY value ASC")
    fun getAll(): List<Tab>
}