package com.joaquimverges.twitter4k.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class TwitterObject {
    abstract val id: String
}

@Serializable
data class Tweet(
    override val id: String,
    val text: String,
    @SerialName("author_id") val authorId: String? = null,
) : TwitterObject()

@Serializable
data class User(
    override val id: String,
    val username: String,
    val name: String,
) : TwitterObject()