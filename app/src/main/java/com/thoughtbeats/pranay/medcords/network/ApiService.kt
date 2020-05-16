package com.thoughtbeats.pranay.medcords.network

import com.thoughtbeats.pranay.medcords.model.RequestParameter
import com.thoughtbeats.pranay.medcords.model.ResponseData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/mhc/test_handle_click")
    fun sendClickedButton(@Body requestParameter: RequestParameter): Single<ResponseData>

}