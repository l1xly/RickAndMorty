package com.example.android.rickandmorty.util

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.models.Character
import com.example.android.rickandmorty.models.Status

@BindingAdapter("app:imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String) {
    imageView.load(imageUrl)
}

@BindingAdapter("app:genderAndSpecies")
fun bindGenderAndSpecies(textView: TextView, character: Character) {
    textView.text = "${character.gender.gender}, ${character.species}"
}

@BindingAdapter("app:status")
fun bindStatus(textView: TextView, status: Status) {
    val context = textView.context

    when (status) {
        Status.ALIVE -> {
            with(textView) {
                setTextColor(ContextCompat.getColor(context, R.color.green))
                text = Status.ALIVE.status
            }
        }
        Status.DEAD -> {
            with(textView) {
                setTextColor(ContextCompat.getColor(context, R.color.red))
                text = Status.DEAD.status
            }
        }
        Status.UNKNOWN -> {
            with(textView) {
                setTextColor(Color.BLUE)
                text = Status.UNKNOWN.status
            }
        }
    }
}