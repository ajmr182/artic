package com.ajdev.artic.ui.addproductscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class AddProductScreen: Screen {
    @Composable
    override fun Content() {
        AddProductScreenContent()
    }
}

@Composable
fun AddProductScreenContent() {
    val navigator = LocalNavigator.current
    var name by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") })
        OutlinedTextField(value = stock, onValueChange = { stock = it }, label = { Text("Stock") }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
        )
        OutlinedTextField(value = price, onValueChange = { price = it }, label = { Text("Precio") })
        OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Categoría") })
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Descripción") })

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { /* guardar producto */ }) {
                Text("Guardar")
            }
            OutlinedButton(onClick = { navigator?.pop() }) {
                Text("Cancelar")
            }
        }
    }
}