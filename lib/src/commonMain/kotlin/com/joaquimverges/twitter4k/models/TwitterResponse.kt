package com.joaquimverges.twitter4k.models

import kotlinx.serialization.Serializable

@Serializable
data class TwitterResponse<T: TwitterObject>(
    val data: List<T>
)