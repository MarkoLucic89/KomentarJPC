package com.example.komentarjpc.di

import com.example.komentarjpc.common.Constants
import com.example.komentarjpc.data.remote.KomentarApi
import com.example.komentarjpc.data.repository.KomentarRepositoryimpl
import com.example.komentarjpc.domain.repository.KomentarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKomentarApi(): KomentarApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KomentarApi::class.java)
    }

    @Provides
    @Singleton
    fun provideKomentarRepository(api: KomentarApi) : KomentarRepository {
        return KomentarRepositoryimpl(api)
    }
}