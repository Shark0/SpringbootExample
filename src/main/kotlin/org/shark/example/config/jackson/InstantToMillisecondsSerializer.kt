package org.shark.example.config.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException
import java.time.Instant

class InstantToMillisecondsSerializer : JsonSerializer<Instant>() {

    @Throws(IOException::class)
    override fun serialize(
        instant: Instant,
        jsonGenerator: JsonGenerator,
        serializerProvider: SerializerProvider
    ) {
        jsonGenerator.writeNumber(instant.toEpochMilli())
    }
}
