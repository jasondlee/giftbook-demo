package com.steeplesoft.giftbook.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.steeplesoft.giftbook.NavigationConfig
import com.steeplesoft.giftbook.database.db
import com.steeplesoft.giftbook.logger.AppLogger

val nav = StackNavigation<NavigationConfig>()


class RootComponent(componentContext: ComponentContext) :
    ComponentContext by componentContext {
    init {
        val dao = db.occasionDao()
        AppLogger.i("The dao is $dao")
    }

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
            is NavigationConfig.Dummy -> DummyComponent(componentContext)
        }
    }
}
