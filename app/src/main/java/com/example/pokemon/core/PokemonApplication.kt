package com.example.pokemon.core

import android.app.Application
import android.content.Context

class PokemonApplication : Application() {

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        fun getContext() : Context = this.getContext()
    }

    fun getContext(): Context {
        return context
    }
}