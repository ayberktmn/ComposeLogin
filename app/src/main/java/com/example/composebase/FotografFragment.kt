package com.example.composebase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController


@Composable
fun FotografFragment() {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Fotoğraflar",
            modifier = Modifier.padding(bottom = 8.dp),
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            Image(

                painter = painterResource(R.drawable.android),
                contentDescription = "Hoşgeldiniz resmi",
                modifier = Modifier
                    .size(200.dp)
            )
            Image(
                painter = painterResource(R.drawable.game),
                contentDescription = "Hoşgeldiniz resmi",
                modifier = Modifier
                    .size(200.dp)
            )
        }
    }
}

