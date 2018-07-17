package com.vincentvu.a312geek.myfirstapp

import android.os.Parcel
import android.os.Parcelable

class UserList constructor(val username: String, val password: String, val email: String) : Parcelable {

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(username)
        writeString(password)
        writeString(email)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UserList> = object : Parcelable.Creator<UserList> {
            override fun createFromParcel(source: Parcel): UserList {
                return UserList(source)
            }
            override fun newArray(size: Int):
                    Array<UserList?> {
                return arrayOfNulls(size)
            }
        }
    }
}
