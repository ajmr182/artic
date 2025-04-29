package com.ajdev.artic.di

import com.ajdev.artic.data.local.dao.ProductsDao
import com.ajdev.artic.data.local.dao.ProductsDaoImpl
import com.ajdev.artic.data.repository.ProductRepository
import org.koin.dsl.module

val databaseModule = module {
    single<ProductsDao> { ProductsDaoImpl() }
    single { ProductRepository(get()) }
}