package com.example.android.rickandmorty.di

import com.example.android.rickandmorty.data.network.CharactersApi
import com.example.android.rickandmorty.data.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(charactersApi: CharactersApi): CharactersRepository {
        return CharactersRepository(charactersApi)
    }
}