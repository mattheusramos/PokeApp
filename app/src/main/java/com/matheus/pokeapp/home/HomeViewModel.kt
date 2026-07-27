package com.matheus.pokeapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.pokeapp.data.model.PokemonResult
import com.matheus.pokeapp.data.remote.RetrofitInstance
import com.matheus.pokeapp.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PokemonRepository = PokemonRepository(RetrofitInstance.api)
) : ViewModel() {

    private val _pokemons = MutableStateFlow<List<PokemonResult>>(emptyList())
    val pokemons: StateFlow<List<PokemonResult>> = _pokemons.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _search = MutableStateFlow("")
    val search = _search.asStateFlow()

    fun onSearchChange(text: String) {
        _search.value = text
        if (text.isBlank()) {
            _pokemons.value = allPokemons
        } else {
            _pokemons.value = allPokemons.filter { it.name.contains(text, ignoreCase = true) }
        }
    }

    private var allPokemons = listOf<PokemonResult>()

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = repository.getPokemonList()

                allPokemons = response.results
                _pokemons.value = response.results
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false

            }
        }
    }
}