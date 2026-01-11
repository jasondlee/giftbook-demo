package com.steeplesoft.giftbook

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.steeplesoft.giftbook.ui.RootComponent
import com.steeplesoft.giftbook.ui.RootContent

@Composable
fun App(component: RootComponent) {
    MaterialTheme {
        RootContent(component)
    }
}
