package com.ajdev.artic.data

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest

class SupabaseSetup {
    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = "https://ueucbfaodlgvntvrmyrb.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVldWNiZmFvZGxndm50dnJteXJiIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDYzMTkyMTYsImV4cCI6MjA2MTg5NTIxNn0.dPmWtA2xCtSytI8yPyEbOBPPeQM7lx6JswrFYAhb8WE"
    ) {
        install(GoTrue)
        install(Postgrest)
    }
}