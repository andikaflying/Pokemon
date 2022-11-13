package com.example.pokemon.utilities

import android.content.Context
import com.example.pokemon.data.repository.PokemonRepository
import com.example.pokemon.viewmodels.PokemonViewModelFactory

object InjectorUtils {
    private fun getPokemonRepository(context: Context): PokemonRepository {
        return PokemonRepository();
    }

    fun providePokemonViewModelFactory(context: Context): PokemonViewModelFactory {
        val repository = getPokemonRepository(context)
        return PokemonViewModelFactory(repository)
    }
}