package com.example.pokemon.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemon.core.calling_api.APIList
import com.example.pokemon.core.calling_api.RetrofitManager
import com.example.pokemon.data.model.PokemonListResponse
import com.example.pokemon.data.model.detail.PokemonDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {

    val apiList : APIList = RetrofitManager.service;

    fun displayPokemonList() : LiveData<PokemonListResponse> {
        val result : MutableLiveData<PokemonListResponse> = MutableLiveData();

        apiList.displayPokemonList(50).enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(call: Call<PokemonListResponse>, response: retrofit2.Response<PokemonListResponse>) {
                Log.e("TAG", "Masuk Pokemon Repository 21");
                result.value = response.body();
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                Log.e("TAG", "onFailure");
            }
        })

        return result;
    }

    fun displayPokemonDetail(id : String?) : LiveData<PokemonDetailResponse> {
        val result : MutableLiveData<PokemonDetailResponse> = MutableLiveData();

        apiList.displayPokemonDetail(id).enqueue(object : Callback<PokemonDetailResponse> {
            override fun onResponse(call: Call<PokemonDetailResponse>, response: Response<PokemonDetailResponse>) {
                result.value = response.body();
                Log.e("TAG", "Pokemon name = " + result.value?.name);
            }

            override fun onFailure(call: Call<PokemonDetailResponse>, t: Throwable) {
                Log.e("TAG", "onFailure");
            }
        })

        return result;
    }
}