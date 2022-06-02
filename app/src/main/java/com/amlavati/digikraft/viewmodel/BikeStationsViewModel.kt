package com.amlavati.digikraft.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amlavati.digikraft.model.BikeStationData
import com.amlavati.digikraft.repository.DataSourceRepository
import com.amlavati.digikraft.util.UNI_TAG
import com.amlavati.digikraft.util.debugLogger
import kotlinx.coroutines.*

/**
 * Created by Sudarshan Bhatt on 02-06-2022
 * All rights reserved to https://www.amlavati.com
 */

class BikeStationsViewModel(private val repository: DataSourceRepository) : ViewModel() {

    //    private val TAG = WeatherViewModel::class.qualifiedName
    val errorMessage = MutableLiveData<String>()
    val bikeStations = MutableLiveData<BikeStationData>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.message}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getBikeStationList(pType: String?, co: String?) {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            loading.postValue(true)
            val response = repository.getBikeStationData(pType, co)
//                debugLogger(UNI_TAG, "response" + response.body());
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    debugLogger(UNI_TAG, "response is successful")
                    bikeStations.postValue(response.body())
                    loading.postValue(false)
                } else {
                    debugLogger(UNI_TAG, "response not successful")
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }


    private fun onError(message: String) {
        debugLogger(UNI_TAG, "hello here $message")
        errorMessage.postValue(message)
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}