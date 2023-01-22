package com.example.proyek_akhir_mobileprogramming.di

import com.example.proyek_akhir_mobileprogramming.core.domain.usecase.movie.MovieInteractor
import com.example.proyek_akhir_mobileprogramming.core.domain.usecase.movie.MovieUseCase
import com.project.proyek_akhir_mobile_programming.ui.movie.MovieViewModel
import com.example.proyek_akhir_mobileprogramming.ui.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
}