package com.saugat.softuserreplica.model

import android.os.Parcel
import android.os.Parcelable

data class Student (
    val studentId: Int? = null,
    val studentName: String? = null,
    val studentAddress: String? = null,
    val studentAge: Int? = null,
    val studentGender: String? = null
        ): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString()) {
        }

        override fun describeContents(): Int {
                TODO("Not yet implemented")
        }

        override fun writeToParcel(dest: Parcel?, flags: Int) {
                TODO("Not yet implemented")
        }

        companion object CREATOR : Parcelable.Creator<Student> {
                override fun createFromParcel(parcel: Parcel): Student {
                        return Student(parcel)
                }

                override fun newArray(size: Int): Array<Student?> {
                        return arrayOfNulls(size)
                }
        }
}