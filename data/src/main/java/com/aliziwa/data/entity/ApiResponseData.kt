package com.aliziwa.data.entity

import com.aliziwa.data.BuildConfig
import com.aliziwa.domain.entity.QueryData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIResponseData(
    @SerialName("RelatedTopics")
    val relatedTopics: List<RelatedTopic>,
)

@Serializable
data class RelatedTopic(
    @SerialName("FirstURL")
    val firstURL: String,

    @SerialName("Icon")
    val icon: Icon,

    @SerialName("Result")
    val result: String,

    @SerialName("Text")
    val text: String
) {
    fun toQueryData() : QueryData {
        val textAndDescription = text.split("-")
        val characterName = if(textAndDescription.isEmpty()) "" else textAndDescription[0]
        val description = if(textAndDescription.size < 2) "" else textAndDescription[1]

        return QueryData(
            characterName,
            BuildConfig.BASE_URL + icon.url,
            description
        )
    }
}

@Serializable
data class Icon(
    @SerialName("Height")
    val height: String,

    @SerialName("URL")
    val url: String,

    @SerialName("Width")
    val width: String
)
