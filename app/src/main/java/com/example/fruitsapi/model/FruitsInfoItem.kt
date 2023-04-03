package com.example.fruitsapi.model


import com.google.gson.annotations.SerializedName

data class FruitsInfoItem(
    @SerializedName("family")
    val family: String,
    @SerializedName("genus")
    val genus: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nutritions")
    val nutritions: Nutritions,
    @SerializedName("order")
    val order: String
)