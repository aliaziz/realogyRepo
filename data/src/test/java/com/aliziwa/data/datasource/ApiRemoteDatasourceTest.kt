package com.aliziwa.data.datasource

import com.aliziwa.data.ApiService
import com.aliziwa.data.datasource.util.DataTestUtil
import com.aliziwa.data.datasource.util.RxRule
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class ApiRemoteDatasourceTest {

    @get:Rule
    val rxRule = RxRule()

    @MockK
    private lateinit var apiService: ApiService

    private lateinit var apiRemoteDatasource: ApiRemoteDatasource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        apiRemoteDatasource = ApiRemoteDatasource(apiService)
    }

    @Test
    fun `test fetch data query makes api call`() {
        every { apiService.fetchData() } returns Single.just(DataTestUtil.createApiResponseData())
        val test = apiRemoteDatasource.fetchQueryData().test()

        verify { apiService.fetchData() }
        test.assertComplete()
            .assertNoErrors()
            .assertValue {
                it == DataTestUtil.createApiResponseData()
            }
    }
}

