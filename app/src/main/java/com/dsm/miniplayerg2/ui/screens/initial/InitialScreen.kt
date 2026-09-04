package com.dsm.miniplayerg2.ui.screens.initial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.dsm.miniplayerg2.ui.theme.Black
import com.dsm.miniplayerg2.ui.theme.Gray

@Composable
fun InitialScreen(onLogin: () -> Unit = {},
                  onSignUp: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Gray, Black), startY = 0f, endY = 600f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

}