package com.example.pokemon.core.calling_api

import com.example.pokemon.data.model.PokemonListResponse
import com.example.pokemon.data.model.detail.PokemonDetailResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIList {

    @GET("api/v2/pokemon/")
    fun displayPokemonList(@Query("limit") limit: Int): Call<PokemonListResponse>

    @GET("api/v2/pokemon/{id}")
    fun displayPokemonDetail(@Path("id") id: String?): Call<PokemonDetailResponse>
}