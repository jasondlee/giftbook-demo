package com.steeplesoft.giftbook.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.steeplesoft.giftbook.model.Occasion
import com.steeplesoft.giftbook.model.OccasionRecipient
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@Dao
interface OccasionDao {
    @Transaction
    @Query("SELECT * FROM Occasion")
    suspend fun getAll(): List<Occasion>

    @Query("SELECT * FROM Occasion WHERE id = :occasionId")
    suspend fun getOccasion(occasionId: Long): Occasion

    @Insert
    @Transaction
    suspend fun addRecipients(vararg recips: OccasionRecipient)

    @Transaction
    @Query("SELECT * from Occasion where eventDate >= :limit order by eventDate")
    suspend fun getFutureOccasions(limit: String = LocalDate.now().format(LocalDate.Formats.ISO)): List<Occasion>

    @Insert
    @Transaction
    suspend fun insertOccasionRecip(occasion: OccasionRecipient)

    @Update
    @Transaction
    suspend fun updateOccasionRecip(occasion: OccasionRecipient)

    @Delete
    @Transaction
    suspend fun deleteOccasionRecip(occasion: OccasionRecipient)

    @Insert
    @Transaction
    suspend fun insert(occasion: Occasion) : Long

    @Update
    @Transaction
    suspend fun update(occasion: Occasion)

    @Delete
    @Transaction
    suspend fun delete(occasion: Occasion)
}

@OptIn(ExperimentalTime::class)
fun LocalDate.Companion.now() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
