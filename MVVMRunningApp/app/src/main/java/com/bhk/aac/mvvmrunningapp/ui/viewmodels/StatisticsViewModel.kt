package com.bhk.aac.mvvmrunningapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.bhk.aac.mvvmrunningapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// collect all the data from repository, provide it for all frags that need mainViewModel
@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel(){

}