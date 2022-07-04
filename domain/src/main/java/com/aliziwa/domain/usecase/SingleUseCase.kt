package com.aliziwa.domain.usecase

import io.reactivex.rxjava3.core.Single

interface SingleUseCase<R: Any> {
    operator fun invoke(): Single<R>
}
