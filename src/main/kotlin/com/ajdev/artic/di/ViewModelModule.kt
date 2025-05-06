package com.ajdev.artic.di

import com.ajdev.artic.ui.login.LoginViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
}