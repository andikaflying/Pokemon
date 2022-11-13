package com.example.pokemon.views.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokemon.R
import com.example.pokemon.adapter.PokemonGVAdapter
import com.example.pokemon.data.model.detail.PokemonDetailResponse
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.databinding.ActivityPokemonDetailBinding
import com.example.pokemon.utilities.InjectorUtils
import com.example.pokemon.viewmodels.PokemonViewModel

class PokemonDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: PokemonViewModel
    private lateinit var binding : ActivityPokemonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon_detail)
        val factory = InjectorUtils.providePokemonViewModelFactory(baseContext);
        viewModel = ViewModelProvider(this, factory).get(PokemonViewModel::class.java)

        if (intent.hasExtra("ID")) {
            val id = intent.getStringExtra("ID");
            viewModel.displayPokemonDetail(id).observe(this, Observer { item ->
                if (item != null) {
                    displayDetail(item, id!!);
                }
            })
        }
    }

    fun displayDetail(item : PokemonDetailResponse, id: String) {
        Glide.with(this)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/" + id + ".png")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivPokemon)

        var status: String = "";
        item.stats.forEach {
            it -> status = status + it.stat?.name + " : " + it.baseStat + "\n"
        }

        binding.tvStats.setText(status);
    }
}