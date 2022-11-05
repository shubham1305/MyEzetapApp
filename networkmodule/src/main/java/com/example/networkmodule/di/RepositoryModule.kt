package com.example.networkmodule.di

import com.example.networkmodule.api.NetworkApi
import com.example.networkmodule.data.repository.CustomUIRepositoryImpl
import com.example.networkmodule.domain.repository.CustomUIRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesNetworkRepository(
        networkApi: NetworkApi
    ): CustomUIRepository = CustomUIRepositoryImpl(networkApi)
}