package com.aliziwa.domain.usecase

import com.aliziwa.domain.entity.QueryData
import com.aliziwa.domain.repository.CharacterQueryRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val queryRepository: CharacterQueryRepository
): SingleUseCase<List<QueryData>> {
    override fun invoke(): Single<List<QueryData>> {
        return queryRepository.getCharacters()
    }
}
