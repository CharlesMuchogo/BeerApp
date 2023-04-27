package com.example.beerapp.di

import com.example.beerapp.network.ApiService
import com.example.beerapp.repository.BeerRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppRepository(): ApiService {
        return Retrofit.Builder().baseUrl( "https://api.punkapi.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun  provideBeerRepository(apiService: ApiService): BeerRepository{
        return BeerRepository(apiService)
    }
}