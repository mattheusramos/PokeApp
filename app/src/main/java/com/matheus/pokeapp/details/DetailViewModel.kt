package com.matheus.pokeapp.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.pokeapp.data.model.PokemonDetails
import com.matheus.pokeapp.data.remote.RetrofitInstance
import com.matheus.pokeapp.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: PokemonRepository = PokemonRepository(RetrofitInstance.api)
) : ViewModel() {

    private val _pokemon = MutableStateFlow<PokemonDetails?>(null)
    val pokemon = _pokemon.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadPokemon(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                _pokemon.value = repository.getPokemons(id)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}