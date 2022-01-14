package com.example.android.rickandmorty.data.network.models

import com.example.android.rickandmorty.models.Character
import com.example.android.rickandmorty.models.Gender
import com.example.android.rickandmorty.models.Origin
import com.example.android.rickandmorty.models.Status

data class NetworkCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
//    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

//fun List<NetworkCharacter>.asCharacter(): List<Character> {
//    return map {
//        Character(
//            id = it.id,
//            name = it.name,
//            status = it.status.asStatus(),
//            species = it.species,
//            type = it.type,
//            gender = it.gender.asGender(),
//            image = it.image,
//            episode = it.episode,
//            url = it.url,
//            created = it.created
//        )
//    }
//}

fun NetworkCharacter.asCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status.asStatus(),
        species = species,
        type = type,
        gender = gender.asGender(),
        origin = origin,
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun String.asGender(): Gender {
    return when (this) {
        "Female" -> Gender.FEMALE
        "Male" -> Gender.MALE
        "Genderless" -> Gender.GENDERLESS
        else -> Gender.UNKNOWN
    }
}

fun String.asStatus(): Status {
    return when (this) {
        "Alive" -> Status.ALIVE
        "Dead" -> Status.DEAD
        else -> Status.UNKNOWN
    }
}