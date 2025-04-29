package com.ajdev.artic.data.local.dao

import com.ajdev.artic.data.local.db.Products
import com.ajdev.artic.domain.model.Product
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ProductsDaoImpl: ProductsDao {
    override fun addProduct(product: Product) {
        transaction {
            Products.insert {
                it[id] = product.id
                it[name] = product.name
                it[quantity] = product.quantity
                it[price] = product.price
            }
        }
    }

    override fun getAllProducts(): List<Product> {
        return transaction {
            Products.selectAll().map {
                Product(
                    id = it[Products.id],
                    name = it[Products.name],
                    quantity = it[Products.quantity],
                    price = it[Products.price]
                )
            }
        }
    }
}