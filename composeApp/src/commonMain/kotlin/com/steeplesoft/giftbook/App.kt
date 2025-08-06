package com.steeplesoft.giftbook

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun App(component: RootComponent) {
    MaterialTheme {
        RootContent(component)
    }
}
