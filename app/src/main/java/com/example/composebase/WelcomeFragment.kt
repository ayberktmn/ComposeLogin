package com.example.composebase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp



@Composable
fun WelcomeFragment(email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // GIF dosyasının URL'sini belirtin
        val gifResId = R.drawable.compose

        // GIF'i görüntüleyin
        Image(
            painter = painterResource(id = gifResId),
            contentDescription = "Hoşgeldiniz resmi",
            modifier = Modifier.size(200.dp) // Resim boyutunu ayarlayabilirsiniz
        )

        Text("Hoşgeldiniz , $email!")
    }
}

