package com.example.composetest

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composetest.screen.Hal1Screen
import com.example.composetest.screen.Hal2Screen
import androidx.navigation.compose.rememberNavController
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // GreetingPreview()

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = NavDestination.Hal1)
            {
                composable(NavDestination.Hal1) {
                    Hal1Screen(onNavigateToHal2 = { navController.navigate(NavDestination.Hal2) })
                }
                composable(NavDestination.Hal2) {
                    Hal2Screen(onNavigateToHal1 = { navController.navigate(NavDestination.Hal1) })
                }
            }
        }
    }
}

@Composable
fun myProfile (nama: String, nim: String) {
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userInput,
            onValueChange = { newUserInput -> userInput = newUserInput },
            label = { Text(text = "Input data di sini") }
        )

        Button(onClick = {
            val intent = Intent(context, Activity2::class.java)
            val bundle = Bundle()

            bundle.putString("data", userInput)
            intent.putExtras(bundle)
            context.startActivity(intent)

        }) { Text(text = "Click Here to Submit") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()){
            myProfile("Muhammad Alif Azfa Hasani", "245150407111004")
        }
    }
}