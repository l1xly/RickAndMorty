package com.example.android.rickandmorty.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.rickandmorty.databinding.ErrorLoadStateBinding

class CharactersLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<CharactersLoadStateAdapter.LoadStateViewHolder>() {

    class LoadStateViewHolder(private val binding: ErrorLoadStateBinding, retry: () -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryButton.setOnClickListener {
                retry()
            }
        }

        fun bind(loadState: LoadState) {
            with(binding) {
                retryButton.isVisible = loadState is LoadState.Error
                errorTextView.isVisible = loadState is LoadState.Error
                progressBar.isVisible = loadState is LoadState.Loading
            }
        }
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) =
        holder.bind(loadState)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            ErrorLoadStateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            retry
        )
    }
}