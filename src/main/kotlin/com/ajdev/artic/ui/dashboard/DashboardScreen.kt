package com.ajdev.artic.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.ajdev.artic.ui.addproductscreen.AddProductScreen
import com.ajdev.artic.ui.productlistscreen.ProductListScreen
import com.ajdev.artic.ui.sellscreen.SellsScreen

class DashboardScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Dashboard", style = MaterialTheme.typography.h4)
                IconButton(onClick = { /* Ir a config */ }) {
                    Icon(Icons.Default.Settings, contentDescription = "Configuración")
                }
            }

            Spacer(Modifier.height(24.dp))

            // Tarjetas de resumen
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                DashboardCard("Total productos", "250")
                DashboardCard("Bajo stock", "12", Color.Red)
                DashboardCard("Entradas", "+15", Color.Green)
                DashboardCard("Salidas", "-8", Color.Red)
            }

            Spacer(Modifier.height(32.dp))

            Text("Productos con bajo stock", style = MaterialTheme.typography.h6)

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(listOf("Tomates", "Harina", "Aceite")) {
                    ProductChip(name = it)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton("📦 Ver Inventario") { navigator?.push(ProductListScreen()) }
                ActionButton("➕ Agregar Producto") { navigator?.push(AddProductScreen()) }
                ActionButton("🛒 Vender") { navigator?.push(SellsScreen()) }
            }
        }
    }
}

@Composable
fun DashboardCard(title: String, value: String, color: Color = Color.Gray) {
    Card(modifier = Modifier.size(width = 160.dp, height = 100.dp)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title)
            Text(value, color = color)
        }
    }
}

@Composable
fun ProductChip(name: String) {
    Card(shape = RoundedCornerShape(20.dp), backgroundColor = Color.LightGray) {
        Text(
            name,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            //style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun ActionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .height(60.dp)
    ) {
        Text(text)
    }
}