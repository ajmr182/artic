package com.ajdev.artic.ui.productlistscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.ajdev.artic.domain.model.Product
import com.ajdev.artic.ui.addproductscreen.AddProductScreen
import java.math.BigDecimal

class ProductListScreen: Screen {
    @Composable
    override fun Content() {
        ProductListScreenContent()
    }
}

@Composable
fun ProductListScreenContent() {
    val navigator = LocalNavigator.current
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            //OutlinedTextField(value = "searchText", onValueChange = { searchText = it }, label = { Text("Buscar") })
            Button(onClick = { navigator?.push(AddProductScreen()) }) {
                Text("Agregar producto")
            }
        }

        Spacer(Modifier.height(16.dp))

        // Encabezados
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Nombre", Modifier.weight(1f))
            Text("Stock", Modifier.weight(1f))
            Text("Precio", Modifier.weight(1f))
            Text("Categoría", Modifier.weight(1f))
            Text("Acciones", Modifier.weight(1f))
        }

        Divider()

        // Lista
        LazyColumn {
            val productList = listOf(Product(id = "1", name = "alo", quantity = 4, price = BigDecimal("25.50")))
            items(productList) { product ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(product.name, Modifier.weight(1f))
                    Text("${product.quantity}", Modifier.weight(1f))
                    Text("S/${product.price}", Modifier.weight(1f))
                    Row(Modifier.weight(1f)) {
                        IconButton(onClick = { /* Editar */ }) { Icon(Icons.Default.Edit, contentDescription = "Editar") }
                        IconButton(onClick = { /* Eliminar */ }) { Icon(Icons.Default.Delete, contentDescription = "Eliminar") }
                    }
                }
                Divider()
            }
        }
    }
}