package com.aliziwa.realogyassignment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.aliziwa.domain.entity.QueryData
import com.aliziwa.domain.usecase.GetCharacterUseCase
import com.aliziwa.realogyassignment.RxRule
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

internal class CharacterViewModelTest {

    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @get:Rule
    val rxRule = RxRule()

    private lateinit var characterViewModel: CharacterViewModel

    @MockK
    private lateinit var getCharacterUseCase: GetCharacterUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        characterViewModel = CharacterViewModel(getCharacterUseCase)
    }

    @Test
    fun `test uiState transitions to proper states on event`() {
        every { getCharacterUseCase() }.returns(Single.just(emptyList()))
        characterViewModel.fetchQuery()

        val result = characterViewModel.data.get()
        verify { getCharacterUseCase() }
        Truth.assertThat(result).isEqualTo(UIState.Success(emptyList()))
    }

    @Test
    fun `test uiState updates to error when call fails`() {
        every { getCharacterUseCase() }.returns(Single.error(Throwable("test error")))
        characterViewModel.fetchQuery()

        val result = characterViewModel.data.get()
        verify { getCharacterUseCase() }
        Truth.assertThat(result).isInstanceOf(UIState.Error::class.java)
    }

    @Test
    fun `test stateToString converts string state`() {
        every { getCharacterUseCase() }.returns(Single.just(listOf(QueryData(
            "Simpson one",
            "test.com/1.png",
            "No description"
        ))))

        characterViewModel.fetchQuery()
        val result = characterViewModel.data.get()

        val convertedString = characterViewModel.stateToString()
        val restoredState = characterViewModel.fromStringToState(convertedString)

        Truth.assertThat(restoredState).isEqualTo(result)
    }
}

fun LiveData<UIState>.get(): UIState? {
    var data: UIState? = null
    val countDownLatch = CountDownLatch(1)
    val observer = object: Observer<UIState> {
        override fun onChanged(t: UIState) {
            data = t
            countDownLatch.countDown()
            this@get.removeObserver(this)
        }
    }
    this.observeForever(observer)

    if(!countDownLatch.await(2, TimeUnit.SECONDS)) {
        throw TimeoutException("Waited longer than usual")
    }
    return data
}
