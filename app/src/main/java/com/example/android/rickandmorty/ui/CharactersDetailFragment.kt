package com.example.android.rickandmorty.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.rickandmorty.R
import com.example.android.rickandmorty.databinding.FragmentCharactersDetailBinding

class CharactersDetailFragment : Fragment(R.layout.fragment_characters_detail) {

    private val viewBinding: FragmentCharactersDetailBinding by viewBinding()

    private val args: CharactersDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.character = args.character
    }
}