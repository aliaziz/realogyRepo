package com.aliziwa.data.datasource

import com.aliziwa.domain.entity.QueryData
import com.aliziwa.domain.repository.CharacterQueryRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QueryImplementation @Inject constructor(
    private val remoteDatasource: ApiRemoteDatasource
) : CharacterQueryRepository {
    override fun getCharacters(): Single<List<QueryData>> {
        return remoteDatasource.fetchQueryData().map { apiResponseData ->
            apiResponseData.relatedTopics.map { relatedTopic ->
                relatedTopic.toQueryData()
            }
        }
    }
}
