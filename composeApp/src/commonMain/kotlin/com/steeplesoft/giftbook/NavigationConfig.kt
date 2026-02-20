package com.steeplesoft.giftbook

import com.steeplesoft.giftbook.model.GiftIdea
import com.steeplesoft.giftbook.model.Occasion
import com.steeplesoft.giftbook.model.OccasionRecipient
import com.steeplesoft.giftbook.model.Recipient
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationConfig {
    @Serializable
    data class Home(val occasionId: Long? = null) : NavigationConfig

    @Serializable
    data object Occasions : NavigationConfig

    @Serializable
    data object Recipients : NavigationConfig
    @Serializable
    data class AddEditOccasionRecipient(val occasion: Occasion, val recipient: Recipient? = null, val occasionRecip: OccasionRecipient? = null): NavigationConfig


}
