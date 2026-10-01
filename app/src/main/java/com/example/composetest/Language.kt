package com.example.composetest

import androidx.annotation.DrawableRes

data class Language(val id: Int, val name: String, val description: String, @DrawableRes val img: Int)