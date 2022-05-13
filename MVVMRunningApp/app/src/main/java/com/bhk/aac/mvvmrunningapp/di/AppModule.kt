package com.bhk.aac.mvvmrunningapp.di

import android.content.Context
import androidx.room.Room
import com.bhk.aac.mvvmrunningapp.db.RunningDatabase
import com.bhk.aac.mvvmrunningapp.utils.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// in dagger we use singleton as module

@Module // this is a module!
@InstallIn(SingletonComponent::class) // wanna install this module in our app component class as singleton
object AppModule {
    // not actually calling them
    // dagger will call itself

    @Singleton // we only have singleton during the whole lifetime
    @Provides // tells dagger the result of the build function
    // can be used to create other dependency or be injected to classes
    fun provideRunningDatabase(
        @ApplicationContext app: Context,  // dagger hilt will insert appContext in app
    ) = Room.databaseBuilder(
        app, RunningDatabase::class.java, RUNNING_DATABASE_NAME
    ).build()

    // create DAO
    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

}