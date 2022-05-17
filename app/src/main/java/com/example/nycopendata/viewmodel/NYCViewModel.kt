package com.example.nycopendata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nycopendata.common.StateAction
import com.example.nycopendata.model.remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NYCViewModel @Inject constructor(
    private val repository: Repository,
    private val ioDispatcher: CoroutineDispatcher,
    private val coroutineScope: CoroutineScope
) : ViewModel() {

    private val _schoolResponse = MutableLiveData<StateAction>()
    val schoolResponse: MutableLiveData<StateAction>
        get() = _schoolResponse

    private val _schoolSatResponse = MutableLiveData<StateAction>()
    val schoolSatResponse: MutableLiveData<StateAction>
        get() = _schoolSatResponse

    fun getSchoolList() {
        coroutineScope.launch {
            repository.NYCSchoolCatched().collect {
                _schoolResponse.postValue(it)
            }
        }
    }

    fun getSatList() {
        coroutineScope.launch {
            repository.NYCSatCatched().collect {
                _schoolSatResponse.postValue(it)
            }
        }
    }
}