package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
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
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    val languages = listOf<Language>(
        Language(1, "Java", "Bahasa pemrograman lama", R.drawable.javaicon),
        Language(2, "C", "Bahasa pemrograman C", R.drawable.cicon),
        Language(3, "C++", "Bahasa pemrograman game development", R.drawable.cppicon),
        Language(4, "C#", "Bahasa pemrograman game development 2", R.drawable.csharpicon),
        Language(5, "Python", "Bahasa pemrograman modern", R.drawable.pythonicon),
        Language(6, "TypeScript", "Membingungkan", R.drawable.typescripticon),
        Language(7, "JavaScript", "Membingungkan 2", R.drawable.jsicon),
        Language(8, "Rust", "Faster than your average language", R.drawable.rusticon),
        Language(9, "Assembly", "Bahasa pemrograman artefak", R.drawable.asmicon),
        Language(10, "Ruby", "Ada dipakai di RPG Maker", R.drawable.rubyicon),
        Language(11, "R", "Good data visualizer", R.drawable.ricon),
        Language(12, "Lua", "Easy to read", R.drawable.luaicon),
        Language(13, "Bash", "Bash scripting letsgoo", R.drawable.bashicon),
        Language(14, "HTML", "Not a programming language no?", R.drawable.htmlicon)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LanguageListHeader(languages)
        }
    }
}

@Composable
fun LanguageItem(languages: Language){
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Image(
                painter = painterResource(id = languages.img),
                contentDescription = "Programming language image",
                modifier = Modifier.clip(CircleShape).size(30.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = languages.name)
                Text(text = languages.description)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LanguageListHeader(languages: List<Language>){
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = Modifier.fillMaxSize().padding(top = 50.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier.height(100.dp).fillMaxWidth().background(Color.White)
            ) {
                myProfile("Muhammad Alif Azfa Hasani", "245150407111004")
            }
        }
        items(languages){
            languages -> LanguageItem(languages)
        }
    }
}

@Composable
fun myProfile (nama: String, nim: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.pfp),
            contentDescription = "Foto Profil Mahasiswa",
            // modifier = Modifier.clip(CircleShape).size(85.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column() {
        Text(text = "$nama", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = "$nim", fontSize = 14.sp, fontWeight = FontWeight.Normal)
        }
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