package com.steeplesoft.giftbook

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.builtins.serializer

val nav = StackNavigation<NavigationConfig>()


class RootComponent(componentContext: ComponentContext) :
    ComponentContext by componentContext {

    val stack: Value<ChildStack<*, ComponentContext>> = childStack(
        source = nav,
        serializer = NavigationConfig.serializer(),
        initialConfiguration = NavigationConfig.Home,
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(config: NavigationConfig,
                      componentContext: ComponentContext): ComponentContext {
        return when (config) {
            is NavigationConfig.Home -> GreeterComponent(componentContext)
        }
    }
}
