package com.ajdev.artic.di

import com.ajdev.artic.data.repository.login.AuthRepository
import com.ajdev.artic.data.repository.login.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory <AuthRepository>{ AuthRepositoryImpl(get()) }
}