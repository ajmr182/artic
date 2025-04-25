package com.ajdev.artic.ui.sellscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.ajdev.artic.ui.Product

class SellsScreen: Screen {
    @Composable
    override fun Content() {
        SellScreenContent()
    }
}

@Composable
fun SellScreenContent() {
    var selectedProduct by remember { mutableStateOf<Product?>(null) }
    var quantity by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // Dropdown de productos
        ProductDropdown(selectedProduct, onProductSelected = { selectedProduct = it }, listOf(Product(id = 1, name = "alo", stock = 4, price = 30.0, category = "asd", description = "")) )

        if (selectedProduct != null) {
            Text("Disponible: ${selectedProduct!!.stock} unidades")
            Text("Precio unitario: S/${selectedProduct!!.price}")
        }

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Cantidad a vender") }
        )

        val total = selectedProduct?.price?.times(quantity.toIntOrNull() ?: 0) ?: 0.0
        Text("Total: S/ %.2f".format(total))

        Button(onClick = { /* registrar venta */ }) {
            Text("Registrar venta")
        }
    }
}

@Composable
fun ProductDropdown(
    selectedProduct: Product?,
    onProductSelected: (Product) -> Unit,
    productList: List<Product>
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedProduct?.name ?: "",
            onValueChange = {},
            label = { Text("Producto") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth().clickable { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            productList.forEach { product ->
                DropdownMenuItem(onClick = {
                    onProductSelected(product)
                    expanded = false
                }) {
                    Text(product.name)
                }
            }
        }
    }
}