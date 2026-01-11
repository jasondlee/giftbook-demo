package com.steeplesoft.giftbook.database

import androidx.room.TypeConverter

class EventTypeConverter {
    @TypeConverter
    fun toEventType(type: Int): EventType {
        return EventType.of(type)
    }

    @TypeConverter
    fun fromEventType(type: EventType): Int {
        return type.code
    }
}
