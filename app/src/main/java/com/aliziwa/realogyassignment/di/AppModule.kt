package com.aliziwa.realogyassignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliziwa.data.datasource.QueryImplementation
import com.aliziwa.domain.repository.CharacterQueryRepository
import com.aliziwa.realogyassignment.viewmodel.CharacterViewModel
import com.aliziwa.realogyassignment.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideQueryRepository(queryImplementation: QueryImplementation):
            CharacterQueryRepository

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun getItemListViewModel(characterViewModel: CharacterViewModel): ViewModel
}
