package com.example.beerapp.repository

import com.example.beerapp.model.Beer
import com.example.beerapp.network.ApiService
import com.example.beerapp.network.BeerApiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BeerRepository(private val apiService: ApiService) {
    suspend fun getBeers():Flow<BeerApiState<Beer>>{
        return  flow{
           val beer = apiService.getBeers()
           emit(BeerApiState.success(beer))
        }.flowOn(Dispatchers.IO)
    }
}