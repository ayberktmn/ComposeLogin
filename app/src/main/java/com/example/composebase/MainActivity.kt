package com.example.composebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            val navController = rememberNavController()

            NavHost(navController, startDestination = "main") {
                composable("main") {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        val gifResId = R.drawable.compose

                        // GIF'i görüntüleyin
                        Image(
                            painter = painterResource(id = gifResId),
                            contentDescription = "Hoşgeldiniz resmi",
                            modifier = Modifier.size(200.dp) // Resim boyutunu ayarlayabilirsiniz
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("E-posta") },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(bottom = 8.dp)
                        )

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Şifre") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(bottom = 16.dp)
                        )

                        Button(
                            onClick = {
                                // Giriş yapma işlevselliğini burada ekleyin
                                if (email != "" && password != "") {
                                    navController.navigate("welcome")
                                }
                            },
                            enabled = email.isNotBlank() && password.isNotBlank(),
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .padding(bottom = 16.dp)
                        ) {
                            Text("Giriş Yap")
                        }
                    }
                }

                composable("welcome") {
                    WelcomeFragment(email) // email'i WelcomeFragment'a iletiyoruz
                }
            }
        }
    }
}
