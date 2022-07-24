package com.capg.insurance.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.capg.insurance.data.model.InsuranceModel
import com.capg.insurance.data.repository.InsuranceRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var insuranceRepository: InsuranceRepository? = null
    var volumesResponseLiveData: LiveData<InsuranceModel>? = null

    fun init() {
        insuranceRepository = InsuranceRepository()
//        volumesResponseLiveData = insuranceRepository.getVolumesResponseLiveData()
    }


}