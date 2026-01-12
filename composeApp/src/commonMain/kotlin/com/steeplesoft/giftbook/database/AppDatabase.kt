package com.steeplesoft.giftbook.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.steeplesoft.giftbook.database.dao.GiftIdeaDao
import com.steeplesoft.giftbook.database.dao.OccasionDao
import com.steeplesoft.giftbook.database.dao.RecipientDao
import com.steeplesoft.giftbook.model.GiftIdea
import com.steeplesoft.giftbook.model.Occasion
import com.steeplesoft.giftbook.model.OccasionRecipient
import com.steeplesoft.giftbook.model.Recipient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [Occasion::class, GiftIdea::class, Recipient::class, OccasionRecipient::class], version = 1
)
@TypeConverters(LocalDateConverter::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun occasionDao(): OccasionDao
    abstract fun recipientDao(): RecipientDao
    abstract fun giftIdeaDao(): GiftIdeaDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

val db by lazy { getRoomDatabase(getDatabaseBuilder()) }

fun getRoomDatabase(builder: RoomDatabase.Builder<AppDatabase>): AppDatabase {
    val database = builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()

    loadDemoData(database)

    return database
}
