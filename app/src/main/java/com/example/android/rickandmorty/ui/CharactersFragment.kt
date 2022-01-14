package com.example.android.rickandmorty.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.adapters.CharactersAdapter
import com.example.android.rickandmorty.adapters.CharactersLoadStateAdapter
import com.example.android.rickandmorty.databinding.FragmentCharactersBinding
import com.example.android.rickandmorty.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val viewBinding: FragmentCharactersBinding by viewBinding()

    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharactersAdapter {
            findNavController().navigate(
                CharactersFragmentDirections.actionCharactersFragmentToCharactersDetailFragment(it)
            )
        }
        viewBinding.charactersRecyclerView.adapter =
            adapter.withLoadStateFooter(CharactersLoadStateAdapter { adapter.retry() })


        viewLifecycleOwner.lifecycleScope.launch {
            charactersViewModel.allCharacters.collectLatest {
                adapter.submitData(it)
            }
        }

        adapter.addLoadStateListener { loadState ->
            viewBinding.charactersProgressBar.isVisible = when (loadState.refresh) {
                is LoadState.Loading -> true
                is LoadState.Error -> true
                else -> false
            }
            viewBinding.errorLayout.isVisible = loadState.refresh is LoadState.Error
        }
    }
}