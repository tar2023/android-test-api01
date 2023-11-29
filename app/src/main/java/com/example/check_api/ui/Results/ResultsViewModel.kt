package com.example.check_api.ui.Results

import androidx.lifecycle.ViewModel
import com.example.check_api.ResultsRepository
import com.example.check_api.model.FeaturesResponse
import com.example.check_api.model.ResultsResponse

class ResultsViewModel(
    private val repository: ResultsRepository = ResultsRepository(),
) : ViewModel() {
    fun getResult04(
        successCallback: (response: ResultsResponse?) -> Unit,
    ) {
        repository.getResult03 { response ->
            successCallback(response)
        }
    }

    fun getByIndex04(
        index: String,
        successCallback: (response: FeaturesResponse?) -> Unit,
    ) {
        repository.getByIndex03(index) { response ->
            successCallback(response)
        }
    }
}
