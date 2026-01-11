package com.steeplesoft.giftbook.ui

import com.arkivanov.decompose.ComponentContext
import com.steeplesoft.giftbook.getPlatform

class DummyComponent(componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val platform = getPlatform()

    fun saySomething() : String {
        return "I'm another screen!"
    }
}
