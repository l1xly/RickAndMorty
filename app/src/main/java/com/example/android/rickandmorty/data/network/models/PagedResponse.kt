package com.example.android.rickandmorty.data.network.models

data class PagedResponse<T>(
    val info: PageInfo,
    val results: List<T>
)
