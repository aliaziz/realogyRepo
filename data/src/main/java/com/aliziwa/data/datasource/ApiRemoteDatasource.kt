package com.aliziwa.data.datasource

import com.aliziwa.data.ApiService
import javax.inject.Inject

class ApiRemoteDatasource @Inject constructor(
    private val apiService: ApiService
) {
    fun fetchQueryData() = apiService.fetchData()
}
