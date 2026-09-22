package com.example.composetest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R
import com.example.composetest.myProfile

@Composable
fun Hal2Screen(onNavigateToHal1: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen 2")
    }
}

@Composable
fun myProfileScreen2 (nama: String, nim: String) {
    val context = LocalContext.current
    var userInput by remember { mutableStateOf("") }

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
}

@Preview
@Composable
fun PreviewHal2Screen() {
    myProfileScreen2("Muhammad Alif Azfa Hasani", "245150407111004")
    Hal2Screen(onNavigateToHal1 = {})
}