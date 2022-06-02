package com.amlavati.digikraft.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amlavati.digikraft.repository.DataSourceRepository

class BikeStationsViewModelFactory constructor(private val repository: DataSourceRepository) :
    ViewModelProvider.Factory {

    // we can use hilt Multibinding viewmodel if required

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BikeStationsViewModel::class.java)) {
            BikeStationsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}

//    fun <T : ViewModel> T.createFactory(): ViewModelProvider.Factory {
//        val viewModel = this
//        return object : ViewModelProvider.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModel as T
//        }
//    }