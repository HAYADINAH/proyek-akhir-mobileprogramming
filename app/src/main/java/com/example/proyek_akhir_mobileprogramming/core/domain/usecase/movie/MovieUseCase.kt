package com.example.proyek_akhir_mobileprogramming.core.domain.usecase.movie

import com.example.proyek_akhir_mobileprogramming.core.data.remote.Resource
import com.example.proyek_akhir_mobileprogramming.core.domain.model.Movie
import com.example.proyek_akhir_mobileprogramming.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface MovieUseCase{
    fun getMovies(): Flow<Resource<List<Movie>>>
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}