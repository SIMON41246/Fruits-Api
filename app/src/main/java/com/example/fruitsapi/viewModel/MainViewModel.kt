package com.example.fruitsapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fruitsapi.model.API
import com.example.fruitsapi.model.FruitsInfoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listfruits = MutableLiveData<MutableList<FruitsInfoItem>>()

    init {
        getFruitsInfo()
    }

    fun getFruitsInfo() {
        API.result.getFruits().enqueue(object : Callback<MutableList<FruitsInfoItem>> {
            override fun onResponse(
                call: Call<MutableList<FruitsInfoItem>>,
                response: Response<MutableList<FruitsInfoItem>>
            ) {
                if (response.isSuccessful) {
                    listfruits.value = response.body()
                } else {
                    listfruits.value = null
                }
            }

            override fun onFailure(call: Call<MutableList<FruitsInfoItem>>, t: Throwable) {
                listfruits.value = null
            }

        })
    }
}