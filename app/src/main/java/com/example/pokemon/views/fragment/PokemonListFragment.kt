package com.example.pokemon.views.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokemon.adapter.PokemonGVAdapter
import com.example.pokemon.databinding.FragmentMainBinding
import com.example.pokemon.utilities.InjectorUtils
import com.example.pokemon.viewmodels.PokemonViewModel
import java.util.ArrayList

class PokemonListFragment : Fragment() {
    private lateinit var viewModel: PokemonViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: PokemonGVAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = InjectorUtils.providePokemonViewModelFactory(context);
        viewModel = ViewModelProvider(this, factory).get(PokemonViewModel::class.java)
        displayPokemonList();

        return binding.root;
    }

    private fun displayPokemonList() {

        viewModel.displayPokemonList().observe(viewLifecycleOwner, Observer { items ->
            if (items != null) {
                adapter = PokemonGVAdapter(this, requireContext(), items.results)
                binding.idGVPokemonList.adapter = adapter
                binding.idGVPokemonList.setOnItemClickListener(adapter);
            }
        })
    }
}