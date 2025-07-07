package com.steeplesoft.giftbook

import com.arkivanov.decompose.ComponentContext

class GreeterComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
