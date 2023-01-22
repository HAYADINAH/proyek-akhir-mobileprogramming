package com.example.proyek_akhir_mobileprogramming

import android.app.Application
import com.example.proyek_akhir_mobileprogramming.core.di.networkModule
import com.example.proyek_akhir_mobileprogramming.core.di.repositoryModule
import com.example.proyek_akhir_mobileprogramming.di.useCaseModule
import com.example.proyek_akhir_mobileprogramming.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}