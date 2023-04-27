package com.example.beerapp.network

import com.example.beerapp.model.Beer
import retrofit2.http.GET

interface ApiService {
    @GET("beers?page=3&per_page=80")
    suspend fun getBeers() : List<Beer>
}