package com.aliziwa.domain.repository

import com.aliziwa.domain.entity.QueryData
import io.reactivex.rxjava3.core.Single

interface CharacterQueryRepository {
    fun getCharacters(): Single<List<QueryData>>
}
