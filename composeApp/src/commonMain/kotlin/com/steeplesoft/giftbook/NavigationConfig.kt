package com.steeplesoft.giftbook

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationConfig {
    @Serializable
    data object Home : NavigationConfig

    @Serializable
    data object Dummy : NavigationConfig
}
