package com.example.android.rickandmorty.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.rickandmorty.databinding.ItemCharacterBinding
import com.example.android.rickandmorty.models.Character

class CharactersAdapter(private val onCharacterClicked: (Character) -> Unit) :
    PagingDataAdapter<Character, CharactersAdapter.CharactersViewHolder>(DiffCallBack) {

    inner class CharactersViewHolder(
        private val binding: ItemCharacterBinding,
        onCharacterClicked: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onCharacterClicked(absoluteAdapterPosition)
            }
        }

        fun bind(character: Character) {
            binding.character = character
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(itemView) {
            getItem(it)?.let { pos -> onCharacterClicked(pos) }
        }
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Character>() {

        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}