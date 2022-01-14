package com.example.android.rickandmorty.data.network.models

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
