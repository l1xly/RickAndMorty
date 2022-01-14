package com.example.android.rickandmorty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android.rickandmorty.data.repositories.CharactersRepository
import com.example.android.rickandmorty.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersRepository: CharactersRepository) :
    ViewModel() {

    private lateinit var _allCharacters: Flow<PagingData<Character>>
    val allCharacters: Flow<PagingData<Character>>
        get() = _allCharacters

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        _allCharacters = charactersRepository.getAllCharacters().cachedIn(viewModelScope)
    }
}