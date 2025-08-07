package com.steeplesoft.giftbook

import com.arkivanov.decompose.ComponentContext

class DummyComponent(componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val platform = getPlatform()

    fun saySomething() : String {
        return "I'm another screen!"
    }
}
