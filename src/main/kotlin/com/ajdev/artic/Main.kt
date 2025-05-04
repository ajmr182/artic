package com.ajdev.artic

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import com.ajdev.artic.data.local.db.initDatabase
import com.ajdev.artic.di.databaseModule
import com.ajdev.artic.di.repositoryModule
import com.ajdev.artic.di.useCaseModule
import com.ajdev.artic.di.viewModelModule
import com.ajdev.artic.ui.login.LoginScreen
import org.koin.core.context.startKoin

@OptIn(InternalVoyagerApi::class, ExperimentalVoyagerApi::class)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        startKoin {
            modules(viewModelModule, databaseModule, useCaseModule, repositoryModule)
        }
        initDatabase()
        Navigator(LoginScreen())
    }
}