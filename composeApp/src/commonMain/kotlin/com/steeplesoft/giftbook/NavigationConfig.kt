package com.steeplesoft.giftbook

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationConfig {
//    @Serializable
//    data class Foo(val bar: String? = null) : NavigationConfig

    @Serializable
    data class Home() : NavigationConfig
}
