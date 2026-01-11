package com.steeplesoft.giftbook

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.steeplesoft.giftbook.ui.RootComponent

fun MainViewController() = ComposeUIViewController {
    val rootComponent = remember {
        RootComponent(DefaultComponentContext(ApplicationLifecycle()))
    }
    App(rootComponent)
}
