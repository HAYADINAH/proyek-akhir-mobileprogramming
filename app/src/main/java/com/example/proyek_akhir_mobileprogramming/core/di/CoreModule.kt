package com.example.proyek_akhir_mobileprogramming.core.di

import com.example.proyek_akhir_mobileprogramming.BuildConfig
import com.example.proyek_akhir_mobileprogramming.core.data.remote.MovieRemoteDataSource
import com.example.proyek_akhir_mobileprogramming.core.data.remote.network.ApiService
import com.example.proyek_akhir_mobileprogramming.core.data.repository.MovieRepository
import com.example.proyek_akhir_mobileprogramming.core.domain.repository.IMovieRepository
import com.project.proyek_akhir_mobile_programming.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        val httpCliet = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            httpCliet.addInterceptor(logging)
        }

        httpCliet
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

}

val repositoryModule = module {
    single { MovieRemoteDataSource(get()) }
    single<IMovieRepository> { MovieRepository(get()) }
}