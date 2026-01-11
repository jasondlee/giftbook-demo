package com.steeplesoft.giftbook.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pushToFront
import com.steeplesoft.giftbook.NavigationConfig
import com.steeplesoft.giftbook.getPlatform
import com.steeplesoft.giftbook.logger.AppLogger

class GreeterComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val platform = getPlatform()

    fun greet(): String {
        AppLogger.i("Hello, ${platform.name}!")
        return "Hello, ${platform.name}!"
    }

    fun dummy() {
        nav.pushToFront(NavigationConfig.Dummy)
    }
}
