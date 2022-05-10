package com.bhk.aac.mvvmrunningapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timestamp: Long = 0L, // when the run was, millis, easy to sort by date
    var avgSpeedInKMH: Float = 0F,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L, // how long the run was
    var caloriesBurnt: Int = 0
) {
    // let Room create PK
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}