package com.ajdev.artic.ui.login

import androidx.lifecycle.viewModelScope
import com.ajdev.artic.domain.usecase.LoginUseCase
import com.ajdev.artic.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginEvent = MutableSharedFlow<Boolean>()
    val loginEvent = _loginEvent.asSharedFlow()

    fun login() {
        viewModelScope.launch(Dispatchers.Default) {
            val success = loginUseCase.signIn(email.value, password.value)
            _loginEvent.emit(success)
        }
    }

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun resetForm() {
        _email.value = ""
        _password.value = ""
    }
}