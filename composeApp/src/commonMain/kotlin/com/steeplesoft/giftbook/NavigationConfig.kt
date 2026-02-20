package com.steeplesoft.giftbook

import com.steeplesoft.giftbook.model.Occasion
import com.steeplesoft.giftbook.model.OccasionRecipient
import com.steeplesoft.giftbook.model.Recipient
import kotlinx.serialization.Serializable@Serializable
sealed interface NavigationConfig {
    @Serializable
    data object Home : NavigationConfig
    @Serializable
    data class AddEditOccasionRecipient(val occasion: Occasion, val recipient: Recipient? = null, val occasionRecip: OccasionRecipient? = null): NavigationConfig

}


