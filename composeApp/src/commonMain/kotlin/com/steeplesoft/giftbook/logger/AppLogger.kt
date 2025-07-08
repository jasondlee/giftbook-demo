package com.steeplesoft.giftbook.logger

internal const val TAG = "GIFTBOOK"

expect object AppLogger {
    fun e(message: String, throwable: Throwable? = null)
    fun d(message: String)
    fun i(message: String)
}
