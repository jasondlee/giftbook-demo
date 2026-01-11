package com.steeplesoft.giftbook.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.steeplesoft.giftbook.AppContext

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    return getDatabaseBuilder(AppContext.get())
}

private fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("giftbook.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
