package com.bhk.aac.mvvmrunningapp.repositories

import com.bhk.aac.mvvmrunningapp.db.Run
import com.bhk.aac.mvvmrunningapp.db.RunDAO
import javax.inject.Inject

// provide functions of db for ViewModels

class MainRepository @Inject constructor( // dagger's job
    val runDao: RunDAO
){
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    // livedata is asynchronous always! so no need for suspend
    fun getAllRunsSortedByDate() = runDao.getAllRunSortedByDate()
    fun getAllRunsSortedByDistace() = runDao.getAllRunSortedByDistance()
    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunSortedByTimeInMillis()
    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunSortedByAvgSpeed()
    fun getAllRunsSortedByCaloriesBurnt() = runDao.getAllRunSortedByCaloriesBurnt()

    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalCaloriesBurnt() = runDao.getTotalCaloriesBurnt()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

}