package com.example.proyek_akhir_mobileprogramming.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.proyek_akhir_mobileprogramming.core.domain.usecase.movie.MovieUseCase


class TvShowViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getTvShow() = useCase.getTvShow().asLiveData()
}
