package com.example.pokemon.data.model

import android.os.Parcel
import android.os.Parcelable

class PokemonItem(val name: String, val img_url: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) { }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(img_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonItem> {
        override fun createFromParcel(parcel: Parcel): PokemonItem {
            return PokemonItem(parcel)
        }

        override fun newArray(size: Int): Array<PokemonItem?> {
            return arrayOfNulls(size)
        }
    }
}