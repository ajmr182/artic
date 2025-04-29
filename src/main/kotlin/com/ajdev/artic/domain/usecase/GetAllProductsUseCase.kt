package com.ajdev.artic.domain.usecase

import com.ajdev.artic.data.repository.ProductRepository
import com.ajdev.artic.domain.model.Product

class GetAllProductsUseCase(private val repository: ProductRepository) {

    fun getAllProducts(): List<Product> = repository.getAllProduct()
}