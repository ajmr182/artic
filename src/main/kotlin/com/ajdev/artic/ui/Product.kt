package com.ajdev.artic.ui

data class Product(
    val id: Int,
    val name: String,
    val stock: Int,
    val price: Double,
    val category: String,
    val description: String = ""
)
