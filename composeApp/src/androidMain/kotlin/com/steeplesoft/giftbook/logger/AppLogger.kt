@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.steeplesoft.giftbook.logger

import android.util.Log

actual object AppLogger {
    actual fun e(message: String, throwable: Throwable?) {
        if (throwable != null) {
            Log.e(TAG, message, throwable)
        } else {
            Log.e(TAG, message)
        }
    }

    actual fun d(message: String) {
        Log.d(TAG, message)
    }

    actual fun i(message: String) {
        Log.i(TAG, message)
    }
}
