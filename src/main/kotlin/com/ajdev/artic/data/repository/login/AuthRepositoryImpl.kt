package com.ajdev.artic.data.repository.login

import com.ajdev.artic.data.SupabaseSetup
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email

class AuthRepositoryImpl(private val supabaseClient: SupabaseSetup) : AuthRepository {
    override suspend fun signIn(email: String, password: String): Boolean {
        return runCatching{
            supabaseClient.client.gotrue.loginWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } .getOrElse {
            false
        }
    }
}