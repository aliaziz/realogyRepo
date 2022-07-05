package com.aliziwa.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIResponseData(
    @SerialName("RelatedTopics")
    val relatedTopics: List<RelatedTopic>,
)
