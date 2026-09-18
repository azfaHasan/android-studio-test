package com.example.composetest

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.content.Context
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import com.example.composetest.ui.theme.ComposeTestTheme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bundle = intent.extras
        val getUserInput = bundle?.getString("data") ?: "Tidak ada Data"

        setContent {
            screenActivity2(
                "Muhammad Alif Azfa Hasani",
                "245150407111004",
                getUserInput
            )
        }
    }
}

@Composable
fun screenActivity2 (nama: String, nim: String, displayInput: String) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.pfp),
                contentDescription = "Foto Profil Mahasiswa",
                modifier = Modifier.clip(CircleShape).size(85.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column() {
                Text(text = "$nama", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "$nim", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Your input before:")
            Text(text = displayInput)
        }
    }
}