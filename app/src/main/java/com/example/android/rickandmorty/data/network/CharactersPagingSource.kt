package com.example.android.rickandmorty.data.network

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android.rickandmorty.data.network.models.NetworkCharacter
import okio.IOException
import retrofit2.HttpException

class CharactersPagingSource(private val charactersApi: CharactersApi) :
    PagingSource<Int, NetworkCharacter>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkCharacter> {
        return try {
            val currentKey = params.key ?: 1
            val response = charactersApi.getAllCharacters(currentKey).body()!!
            var nextKey: Int? = null

            if (response.info.next != null) {
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextKey = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NetworkCharacter>): Int? =
        state.anchorPosition
}