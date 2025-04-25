package com.ajdev.artic.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class Pantalla2: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Text("Hola")
        Button({navigator?.pop()}) {
            Text("Back")
        }
    }
}