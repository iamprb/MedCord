package com.thoughtbeats.pranay.medcords.repo

import com.thoughtbeats.pranay.medcords.model.RequestParameter
import com.thoughtbeats.pranay.medcords.network.APIClient
import com.thoughtbeats.pranay.medcords.network.ApiService

class HomeRepository {
    val apiService = APIClient.client.create(ApiService::class.java)

    fun sendClickedButtonInfo(requestParameter: RequestParameter)= apiService.sendClickedButton(requestParameter)

}