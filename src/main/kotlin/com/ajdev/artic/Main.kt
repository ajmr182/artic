package com.ajdev.artic

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import com.ajdev.artic.di.viewModelModule
import com.ajdev.artic.ui.login.LoginScreen
import com.ajdev.artic.ui.login.LoginViewModel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject

// Definir la tabla
object Productos : Table() {
    val id = varchar("id", 50)
    val nombre = varchar("nombre", 255)
    val cantidad = integer("cantidad")
    val precio = decimal("precio", 10, 2)
}

@Composable
@Preview
fun App() {
    Database.connect("jdbc:sqlite:artic.db", driver = "org.sqlite.JDBC")

    // Crear la tabla si no existe
    transaction {
        SchemaUtils.create(Productos)
    }

    // Insertar un producto
    transaction {
        Productos.insert {
            it[id] = "1"
            it[nombre] = "Producto demo"
            it[cantidad] = 10
            it[precio] = 25.5.toBigDecimal()
        }
    }

    // Consultar productos
    transaction {
        val productos = Productos.selectAll().map {
            "${it[Productos.nombre]} - ${it[Productos.cantidad]} uds - S/.${it[Productos.precio]}"
        }
        productos.forEach { println(it) }
    }

}

@OptIn(InternalVoyagerApi::class, ExperimentalVoyagerApi::class)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        startKoin {
            modules(viewModelModule)
        }

            Navigator(LoginScreen())
        }
}