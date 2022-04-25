package com.bhk.aac.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.bhk.aac.mvvmnewsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String { // convert Source to String
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source { // convert String to Source class
        return Source(name, name)
    }


}