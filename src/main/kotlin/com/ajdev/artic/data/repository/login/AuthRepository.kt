package com.ajdev.artic.data.repository.login

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Boolean
}