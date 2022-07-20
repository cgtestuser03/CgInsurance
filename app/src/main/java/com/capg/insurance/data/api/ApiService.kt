package com.capg.insurance.data.api

import com.capg.insurance.data.model.InsuranceModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("")
    fun getInsurance(
//        @Query("") query: String?
    ): Call<InsuranceModel?>?
}