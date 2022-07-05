package com.aliziwa.realogyassignment.viewmodel

import com.aliziwa.domain.entity.QueryData
import kotlinx.serialization.Serializable

@Serializable
sealed class UIState {
    @Serializable
    object Loading : UIState()

    @Serializable
    data class Error(val message: String) : UIState()

    @Serializable
    data class Success(val data: List<QueryData>) : UIState()
}
