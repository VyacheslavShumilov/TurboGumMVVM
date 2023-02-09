package com.vshum.turbogum.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LinersEntity(
    val key: Long,
    val id: String,
    val numberLiner: String,
    val brand: String,
    val model: String,
    val wikiArticle: String,
    val video: String?,
    val vkArticle: String,
    val imageUrlLiner: String,
    val index: String,
    val series: String
    ): Parcelable

//data class ProfileEntity(
//    val login: String,
//    val id: Long,
//    val avatarUrl: String
//): java.io.Serializable