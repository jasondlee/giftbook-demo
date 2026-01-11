package com.steeplesoft.giftbook

import android.app.Application
import kotlin.apply

class GiftbookApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AppContext.apply { set(applicationContext) }
    }
}
