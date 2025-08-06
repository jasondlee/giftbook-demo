package com.steeplesoft.giftbook

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle

fun MainViewController() = ComposeUIViewController {
    val rootComponent = remember {
        RootComponent(DefaultComponentContext(ApplicationLifecycle()))
    }
    App(rootComponent)
}
