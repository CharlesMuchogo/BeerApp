package com.example.beerapp.model

import com.google.gson.annotations.SerializedName

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image_url: String?,
)
