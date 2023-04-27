package com.example.beerapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerapp.model.Beer
import com.example.beerapp.network.ApiService
import com.example.beerapp.network.BeerApiState
import com.example.beerapp.network.Status
import com.example.beerapp.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class BeerViewModel@Inject constructor(
    private val apiService: ApiService
) : ViewModel() {
    private  val repository = BeerRepository( apiService
    )

    val beerState = MutableStateFlow(
        BeerApiState<Beer>(
            Status.LOADING,
            listOf(),
            ""
        )
    )

    init {
        getBeer()
    }

    fun  getBeer(){
        beerState.value = BeerApiState.loading()

        viewModelScope.launch {
            repository.getBeers()
                .catch {
                    Log.d("TAG", "getBeer: "+it.message )

                    beerState.value = BeerApiState.error(it.message.toString())
                }
                .collect {

                    beerState.value = BeerApiState.success(it.data)
                }

        }
    }

}