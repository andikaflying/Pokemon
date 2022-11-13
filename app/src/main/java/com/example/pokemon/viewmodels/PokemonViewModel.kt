package com.example.pokemon.viewmodels

import android.provider.MediaStore.Audio.Media
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon.data.model.PokemonListResponse
import com.example.pokemon.data.model.detail.PokemonDetailResponse
import com.example.pokemon.data.repository.PokemonRepository

class PokemonViewModel constructor(private val repository: PokemonRepository) : ViewModel() {
    private val response = MediatorLiveData<PokemonListResponse>();
    private val responsePokemonDetail = MediatorLiveData<PokemonDetailResponse>();

    fun displayPokemonList() : MediatorLiveData<PokemonListResponse> {
        val liveData = repository.displayPokemonList();
        response.addSource(liveData, response::setValue)

        return response;
    }

    fun displayPokemonDetail(id : String?) : MediatorLiveData<PokemonDetailResponse> {
        val liveData = repository.displayPokemonDetail(id);
        responsePokemonDetail.addSource(liveData, responsePokemonDetail::setValue)

        return responsePokemonDetail;
    }

}