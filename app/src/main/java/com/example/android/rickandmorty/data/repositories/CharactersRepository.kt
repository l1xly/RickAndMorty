package com.example.android.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.android.rickandmorty.data.network.CharactersApi
import com.example.android.rickandmorty.data.network.CharactersPagingSource
import com.example.android.rickandmorty.data.network.models.asCharacter
import com.example.android.rickandmorty.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharactersRepository(private val charactersApi: CharactersApi) {

    fun getAllCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 1, enablePlaceholders = false),
            pagingSourceFactory = { CharactersPagingSource(charactersApi) }
        ).flow.map { pagingData ->
            pagingData.map { it.asCharacter() }
        }
    }
}