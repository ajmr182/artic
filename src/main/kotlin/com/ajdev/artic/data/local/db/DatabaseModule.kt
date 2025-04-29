package com.ajdev.artic.data.local.db

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun initDatabase() {
    Database.connect("jdbc:sqlite:artic.db", driver = "org.sqlite.JDBC")
    transaction {
        SchemaUtils.create(Products)
    }
}