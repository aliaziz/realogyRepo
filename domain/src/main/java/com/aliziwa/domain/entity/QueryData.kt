package com.aliziwa.domain.entity

import java.io.Serializable

@kotlinx.serialization.Serializable
data class QueryData(
    val characterName: String,
    val iconUrl: String,
    val description: String
) : Serializable
