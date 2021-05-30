package com.joaquim.library.models

import kotlinx.serialization.Serializable

@Serializable
data class TwitterResponse<T: TwitterEntity>(
    val data: List<T>
)