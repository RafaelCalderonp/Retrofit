package com.example.retrofit.model.remote
import com.google.gson.annotations.SerializedName

data class MarsEstate (
    @SerializedName("id")
    val id: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("img_src")
    val imgSrc: String
)