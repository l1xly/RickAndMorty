package com.example.android.rickandmorty.data.network

import com.example.android.rickandmorty.data.network.models.NetworkCharacter
import com.example.android.rickandmorty.data.network.models.PagedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<PagedResponse<NetworkCharacter>>
}