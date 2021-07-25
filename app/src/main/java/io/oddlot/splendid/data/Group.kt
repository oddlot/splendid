package io.oddlot.splendid.data

import androidx.lifecycle.LiveData
import androidx.room.*
//import io.oddlot.splendid.db

@Entity(
    tableName = "Group",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class Group (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var name: String,
    var contactId: Int?,
)