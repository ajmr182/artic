package com.ajdev.artic.ui.login

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.ajdev.artic.ui.Pantalla2
import com.ajdev.artic.ui.dashboard.DashboardScreen
import org.koin.java.KoinJavaComponent.inject

class LoginScreen() : Screen {
    val viewModel: LoginViewModel by inject(LoginViewModel::class.java)

    @Composable
    override fun Content() {
        val email = viewModel.email.collectAsState().value
        val password = viewModel.password.collectAsState().value

        DisposableEffect(Unit) {
            // Este bloque se ejecuta cuando la pantalla se desmonta
            onDispose {
                viewModel.resetForm()
            }
        }

        LoginScreenContent(
            email = email,
            password = password,
            onEmailChange = { viewModel.onEmailChange(it) } ,
            onPasswordChange = { viewModel.onPasswordChange(it) },
            onSingInClicked = { viewModel.login() })
    }
}

@Composable
fun LoginScreenContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSingInClicked: () -> Unit
) {

    var passwordVisible by remember { mutableStateOf(false) }
    val navigator = LocalNavigator.current

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF9FAFB)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.width(400.dp).padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Logo de la app (puedes reemplazar por Image)
                Text("InventaDesk", fontSize = 24.sp, color = Color(0xFF1E3A8A))

                Text("Inicia sesión para continuar", color = Color(0xFF6B7280))

                OutlinedTextField(
                    value = email,
                    onValueChange = { onEmailChange.invoke(it) },
                    label = { Text("Correo electrónico") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Lock Icon")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { onPasswordChange.invoke(it) },
                    label = { Text("Contraseña") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")
                    },
                    trailingIcon = {
                        val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = icon, contentDescription = "Toggle password visibility")
                        }
                    },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    "¿Olvidaste tu contraseña?",
                    color = Color(0xFF60A5FA),
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.End)
                )

                Button(
                    onClick = {
                        onSingInClicked.invoke()
                        navigator?.push(DashboardScreen())
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF10B981)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Iniciar sesión", color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreenContent("ajmr182@gmail.com", "asdef", {}, {}, {})
}