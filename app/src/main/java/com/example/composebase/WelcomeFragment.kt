package com.example.composebase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeFragment(email: String) {

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
                // GIF dosyasının URL'sini belirtin
                val gifResId = R.drawable.compose

                Image(
                    painter = painterResource(id = gifResId),
                    contentDescription = "Hoşgeldiniz resmi",
                    modifier = Modifier
                        .size(200.dp)
                )

                Text(
                    text = "Hoşgeldiniz, $email",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 15.dp)
                        .clickable {
                            navController.navigate("fotograf")
                        }
                        .background(
                            color = androidx.compose.ui.graphics.Color.Black,
                            shape = RoundedCornerShape(10.dp),
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Resimleri Görüntüle",
                        fontSize = 20.sp,
                        color = androidx.compose.ui.graphics.Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        composable("fotograf") {
            FotografFragment() // FotografFragment'ı burada çağırıyoruz
        }
    }
}


