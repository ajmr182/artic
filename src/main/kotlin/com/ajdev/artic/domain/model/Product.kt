package com.ajdev.artic.domain.model

import java.math.BigDecimal

data class Product(
    val id: String,
    val name: String,
    val quantity: Int,
    val price: BigDecimal,
)