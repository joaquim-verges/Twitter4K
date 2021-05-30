package com.joaquimverges.twitter4k.models

import kotlinx.serialization.Serializable

@Serializable
sealed class TwitterEntity {
    abstract val id: String
}

@Serializable
data class Tweet(
    override val id: String,
    val text: String,
) : TwitterEntity()

@Serializable
data class User(
    override val id: String,
    val username: String,
    val name: String,
) : TwitterEntity()