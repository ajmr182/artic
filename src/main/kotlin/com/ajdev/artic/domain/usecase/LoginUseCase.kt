package com.ajdev.artic.domain.usecase

import com.ajdev.artic.data.repository.login.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend fun signIn(email: String, password: String): Boolean = repository.signIn(email, password)
}