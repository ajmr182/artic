package com.ajdev.artic.data.local.dao

import com.ajdev.artic.domain.model.Product

interface ProductsDao {
    fun addProduct(product: Product)
    fun getAllProducts(): List<Product>
}