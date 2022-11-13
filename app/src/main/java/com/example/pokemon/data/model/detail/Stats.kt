package com.example.pokemon.data.model.detail

import android.os.Parcel
import android.os.Parcelable

data class Stats (
    var baseStat : Int?  = null,
    var effort   : Int?  = null,
    var stat     : Stat? = Stat()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(Stat::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(baseStat)
        parcel.writeValue(effort)
        parcel.writeParcelable(stat, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Stats> {
        override fun createFromParcel(parcel: Parcel): Stats {
            return Stats(parcel)
        }

        override fun newArray(size: Int): Array<Stats?> {
            return arrayOfNulls(size)
        }
    }

}