package com.example.pokemon.data.model

import android.os.Parcel
import android.os.Parcelable

class PokemonListResponse (
    val count : Int?,
    val next : String?,
    val previous : String?,
    val results  : ArrayList<Result?>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        TODO("results")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(count)
        parcel.writeString(next)
        parcel.writeString(previous)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonListResponse> {
        override fun createFromParcel(parcel: Parcel): PokemonListResponse {
            return PokemonListResponse(parcel)
        }

        override fun newArray(size: Int): Array<PokemonListResponse?> {
            return arrayOfNulls(size)
        }
    }

}