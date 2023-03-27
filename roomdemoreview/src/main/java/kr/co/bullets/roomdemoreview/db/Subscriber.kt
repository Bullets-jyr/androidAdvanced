package kr.co.bullets.roomdemoreview.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber_data_table")
data class Subscriber(

    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "subscriber_id")
    @ColumnInfo(name = "subs_id")
    val id: Int,

//    @ColumnInfo(name = "subscriber_name")
    @ColumnInfo(name = "subs_name")
    var name: String,

    @ColumnInfo(name = "subscriber_email")
    var email: String
)