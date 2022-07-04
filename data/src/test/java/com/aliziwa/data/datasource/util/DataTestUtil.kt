package com.aliziwa.data.datasource.util

import com.aliziwa.data.entity.APIResponseData
import com.aliziwa.data.entity.Icon
import com.aliziwa.data.entity.RelatedTopic

object DataTestUtil {
    fun createApiResponseData(): APIResponseData {
        return APIResponseData(
            listOf(
                RelatedTopic(
                    "teting.com",
                    Icon("", "url11", ""),
                    "",
                    ""
                )
            )
        )
    }
}
