package com.steeplesoft.giftbook

class GreeterComponent(
    componentContext: ComponentContext,
    var occasion: Occasion? = null
) : ComponentContext by componentContext
}
