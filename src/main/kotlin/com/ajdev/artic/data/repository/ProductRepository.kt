package com.ajdev.artic.data.repository

import com.ajdev.artic.data.local.dao.ProductsDao
import com.ajdev.artic.domain.model.Product

class ProductRepository(private val dao: ProductsDao) {
    fun addProduct(product: Product) = dao.addProduct(product)
    fun getAllProduct(): List<Product> = dao.getAllProducts()
}