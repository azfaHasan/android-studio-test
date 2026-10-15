package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingContent()
        }
    }
}

@Composable
fun GreetingContent(vm: CounterViewModel = viewModel(), modifier: Modifier = Modifier) {
    val number by vm.currentNumber.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        myProfile("Muhammad Alif Azfa Hasani", "245150407111004")

        Text(
            text = number.toString(),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Button(
            onClick = {vm.onClick("Up")}
        ) { Text("Up", fontSize = 24.sp) }
        Button(
            onClick = {vm.onClick("Down")}
        ) { Text("Down", fontSize = 24.sp) }
        Button(
            onClick = {vm.onClick("Reset")}
        ) { Text("Reset", fontSize = 24.sp) }
    }
}

@Composable
fun myProfile (nama: String, nim: String) {
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