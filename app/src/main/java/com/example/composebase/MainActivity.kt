package com.example.composebase

import android.os.Build
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            val navController = rememberNavController()
            var isEmailValid by remember { mutableStateOf(true) }
            var isShowingEmailError by remember { mutableStateOf(false) }

            val customFont = FontFamily(
                Font(R.font.lora)
            )

            NavHost(navController, startDestination = "main") {
                composable("main") {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        val composeDrawable = R.drawable.compose

                        Image(
                            painter = painterResource(id = composeDrawable),
                            contentDescription = "Hoşgeldiniz resmi",
                            modifier = Modifier.size(200.dp) // Resim boyutunu ayarlayabilirsiniz
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            label = { Text("E-posta") },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(bottom = 8.dp),
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

                        Text(
                            text = "Şifremi unuttum!"
                        )

                        Button(
                            onClick = {
                                isEmailValid = isValidEmail(email) // Email kontrolü burada yapılıyor
                                if (isEmailValid && password.isNotBlank()) {
                                    navController.navigate("welcome")
                                } else {
                                    isShowingEmailError = true
                                }
                            },
                            enabled = email.isNotBlank() && password.isNotBlank(),
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .padding(bottom = 16.dp)
                        ) {
                            Text("Giriş Yap")
                        }
                        if (!isEmailValid && isShowingEmailError) {
                            Text(
                                text = "Lütfen geçerli bir e-posta adresi giriniz.",
                                color = androidx.compose.ui.graphics.Color.Red,
                                fontSize = 18.sp,
                                fontFamily = customFont,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                    }
                }

                composable("welcome") {
                    WelcomeFragment(email) // email'i WelcomeFragment'a iletiyoruz
                }
            }
        }
    }
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    @Preview
    @Composable
    fun SimpleComposablePreview() {
      // bu kod ile uı görüntüleniyor
    }
}
