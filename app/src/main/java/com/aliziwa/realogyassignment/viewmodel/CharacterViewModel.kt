package com.aliziwa.realogyassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aliziwa.domain.usecase.GetCharacterUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val json = Json
    private val _data = MutableLiveData<UIState>()
    val data: LiveData<UIState>
        get() = _data

    fun fetchQuery() {
        _data.postValue(UIState.Loading)
        getCharacterUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ list ->
                _data.postValue(UIState.Success(list))
            }, {
                _data.postValue(UIState.Error(it.message ?: ""))
            })
    }

    fun stateToString(): String {
        return json.encodeToString(_data.value)
    }

    fun fromStringToState(string: String): UIState {
        return json.decodeFromString(string)
    }
}
