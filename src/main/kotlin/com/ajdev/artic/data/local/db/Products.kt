package com.ajdev.artic.data.local.db

import org.jetbrains.exposed.sql.Table

object Products : Table() {
    val id = varchar("id", 50)
    val name = varchar("name", 100)
    val quantity = integer("quantity")
    val price = decimal("price", 10, 2)
}