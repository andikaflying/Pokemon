package com.example.pokemon.data.model.detail

import android.os.Parcel
import android.os.Parcelable

data class Types (var slot : Int?  = null, var type : Type? = Type()) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(Type::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(slot)
        parcel.writeParcelable(type, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Types> {
        override fun createFromParcel(parcel: Parcel): Types {
            return Types(parcel)
        }

        override fun newArray(size: Int): Array<Types?> {
            return arrayOfNulls(size)
        }
    }

}