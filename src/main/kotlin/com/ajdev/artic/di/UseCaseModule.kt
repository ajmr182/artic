package com.ajdev.artic.di

import com.ajdev.artic.domain.usecase.GetAllProductsUseCase
import com.ajdev.artic.domain.usecase.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAllProductsUseCase(get()) }
    single { LoginUseCase(get()) }
}