package com.vshum.turbogum.data.retrofit

import com.google.gson.annotations.SerializedName
import com.vshum.turbogum.domain.entities.LinersEntity

data class LinersEntityDto(
    @SerializedName("Key") val key: Long,
    @SerializedName("Id") val id: String,
    @SerializedName("NumberLiner") val numberLiner: String,
    @SerializedName("Brand") val brand: String,
    @SerializedName("Model") val model: String,
    @SerializedName("WikiArticle") val wikiArticle: String,
    @SerializedName("Video") val video: String,
    @SerializedName("VkArticle") val vkArticle: String,
    @SerializedName("ImageUrlLiner") val imageUrlLiner: String,
    @SerializedName("Index") val index: String,
    @SerializedName("Series") val series: String

    ) {

    fun toLinersEntity() = LinersEntity(key, id, numberLiner, brand, model, wikiArticle, video, vkArticle, imageUrlLiner, index, series)
}

//data class ProfileEntityDto(
//    val login: String,
//    val id: Long,
//    @SerializedName("avatar_url")
//    val avatarUrl: String
//) {
//
//    fun toProfileEntity() = ProfileEntity(login, id, avatarUrl)
//}
