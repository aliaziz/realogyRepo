package com.aliziwa.data

import com.aliziwa.data.entity.APIResponseData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET(BuildConfig.QUERY_URL)
    fun fetchData(): Single<APIResponseData>
}


