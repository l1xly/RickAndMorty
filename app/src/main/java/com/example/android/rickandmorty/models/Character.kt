package com.example.android.rickandmorty.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: Origin,
//    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : Parcelable
