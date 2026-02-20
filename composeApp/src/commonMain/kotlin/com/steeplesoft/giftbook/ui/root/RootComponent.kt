package com.steeplesoft.giftbook.ui.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.steeplesoft.giftbook.NavigationConfig
import com.steeplesoft.giftbook.ui.home.HomeComponent
import com.steeplesoft.giftbook.ui.occasionRecip.AddEditOccasionRecipientComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponent(componentContext: ComponentContext) :
    ComponentContext by componentContext, KoinComponent {
    private val nav : StackNavigation<NavigationConfig> by inject()

    val stack: Value<ChildStack<*, ComponentContext>> = childStack(
        source = nav,
        serializer = NavigationConfig.serializer(),
        initialConfiguration = NavigationConfig.Home(),
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(config: NavigationConfig,
                      componentContext: ComponentContext): ComponentContext {
        return when (config) {
            is NavigationConfig.Home -> HomeComponent(componentContext)
            is NavigationConfig.AddEditOccasionRecipient -> AddEditOccasionRecipientComponent(componentContext, config.occasion, config.recipient, config.occasionRecip)
            else -> {
                TODO()
            }
        }
    }
}
