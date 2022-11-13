package com.example.pokemon.data.model.detail

import android.os.Parcel
import android.os.Parcelable

data class PokemonDetailResponse (
    var id                     : Int?                   = null,
    var name                   : String?                = null,
    var types                  : ArrayList<Types>       = arrayListOf(),
    var height : Int? = null,
    var weight                 : Int?                   = null,
    var moves                  : ArrayList<Moves>       = arrayListOf(),
    var stats                  : ArrayList<Stats>       = arrayListOf(),
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        TODO("types"),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("moves"),
        TODO("stats")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeValue(height)
        parcel.writeValue(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonDetailResponse> {
        override fun createFromParcel(parcel: Parcel): PokemonDetailResponse {
            return PokemonDetailResponse(parcel)
        }

        override fun newArray(size: Int): Array<PokemonDetailResponse?> {
            return arrayOfNulls(size)
        }
    }
}