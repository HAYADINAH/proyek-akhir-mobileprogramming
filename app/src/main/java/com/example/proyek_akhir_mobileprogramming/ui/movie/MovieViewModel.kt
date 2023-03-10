package com.project.proyek_akhir_mobile_programming.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.proyek_akhir_mobileprogramming.core.domain.usecase.movie.MovieUseCase


class MovieViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getMovies() = useCase.getMovies().asLiveData()
}