package com.example.pokemon.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemon.data.repository.PokemonRepository

class PokemonViewModelFactory(private val repository : PokemonRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = PokemonViewModel(repository) as T

}