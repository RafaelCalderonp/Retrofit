package com.example.retrofit.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.local.MarsDao
import com.example.retrofit.model.local.MarsEntity
import com.example.retrofit.model.remote.MarsEstate
import com.example.retrofit.model.remote.RetrofitClient

class MarsRepository (private  val marsDao: MarsDao){
    private val retrofitClient = RetrofitClient.getRetrofit()
    val dataFromInternet = MutableLiveData<List<MarsEstate>>()
    val listAllLand : LiveData<List<MarsEntity>> = marsDao.getAllLand()

    fun convertedData (list : List<MarsEstate>) : List<MarsEntity>{
        val listado = mutableListOf<MarsEntity>()
        list.map {
            listado.add(MarsEntity(it.id, it.price, it.type, it.imgSrc))
        }
        return listado
    }


    suspend fun fetchMarsData() {
        try {
            val response = retrofitClient.fetchMarsData()
            when (response.code()){
                in 200..299 -> response.body()?.let { marsDao.insertAllLand(convertedData(it)) }
                in 300..301 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")

            }

        } catch (t : Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }


}
