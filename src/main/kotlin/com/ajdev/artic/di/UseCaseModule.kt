package com.ajdev.artic.di

import com.ajdev.artic.domain.usecase.GetAllProductsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAllProductsUseCase(get()) }
}