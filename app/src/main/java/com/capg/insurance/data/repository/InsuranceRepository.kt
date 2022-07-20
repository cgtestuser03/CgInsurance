package com.capg.insurance.data.repository

import com.capg.insurance.data.api.ApiService
import com.capg.insurance.data.model.InsuranceModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsuranceRepository {

    private var apiService: ApiService? = null
    private var volumesResponseLiveData: androidx.lifecycle.MutableLiveData<InsuranceModel>? = null

    fun InsuranceRepository() {
        volumesResponseLiveData = androidx.lifecycle.MutableLiveData()

        val interceptor = HttpLoggingInterceptor()
//        interceptor.level(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        apiService = Retrofit.Builder()
            .baseUrl("")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}