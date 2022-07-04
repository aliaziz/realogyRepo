package com.aliziwa.data.datasource

import com.aliziwa.data.BuildConfig
import com.aliziwa.data.entity.Icon
import com.aliziwa.data.entity.RelatedTopic
import com.aliziwa.domain.entity.QueryData
import org.junit.Test
import com.google.common.truth.Truth

internal class RelatedTopicTest {

    @Test
    fun `test toQueryData returns proper model when text has hyphen`() {
        val relatedTopicWithHyphen = RelatedTopic(
            "",
            Icon(
                "12",
                "testing.com/1.png",
                "2"
            ),
            "",
            "ABC - and description"
        )
        val expected = QueryData(
            "ABC ",
            BuildConfig.BASE_URL + "testing.com/1.png",
            " and description"
        )
        Truth.assertThat(relatedTopicWithHyphen.toQueryData()).isEqualTo(expected)
    }

    @Test
    fun `test toQueryData returns empty description when text has no hyphen`() {
        val relatedTopicWithNoHyphen = RelatedTopic(
            "",
            Icon(
                "12",
                "testing.com/1.png",
                "2"
            ),
            "",
            "ABC"
        )
        val expected = QueryData(
            "ABC",
            BuildConfig.BASE_URL + "testing.com/1.png",
            ""
        )
        Truth.assertThat(relatedTopicWithNoHyphen.toQueryData()).isEqualTo(expected)
    }

    @Test
    fun `test toQueryData returns empty title and description when text is empty`() {
        val relatedTopicWithEmptyText = RelatedTopic(
            "",
            Icon(
                "12",
                "testing.com/1.png",
                "2"
            ),
            "",
            ""
        )
        val expected = QueryData(
            "",
            BuildConfig.BASE_URL + "testing.com/1.png",
            ""
        )
        Truth.assertThat(relatedTopicWithEmptyText.toQueryData()).isEqualTo(expected)
    }
}
