package de.bindoc.mongoyeartest

import org.bson.types.ObjectId
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.repository.MongoRepository
import java.time.Year

@SpringBootApplication
class MongoYearTestApplication

fun main(args: Array<String>) {
    runApplication<MongoYearTestApplication>(*args)
}


interface FoobarRepository: MongoRepository<Foobar, ObjectId>

data class Foobar(val id: ObjectId? = null, val year: Year, val name: String) {
    private constructor():this(null, Year.MIN_VALUE.let { Year.of(it) }, name = "")
}


/**
 * adding this configuration solves the issue.
 *
 */
@Configuration
class MongoCustomConverterConfig {
    @Bean
    fun mongoCustomConversions(): MongoCustomConversions =
        MongoCustomConversions(listOf(
            YearToIntConverter(),
            IntToYearConverter()
        ))



    @WritingConverter
    class YearToIntConverter: Converter<Year, Int> {
        override fun convert(p0: Year): Int? = p0.value
    }

    @ReadingConverter
    class IntToYearConverter: Converter<Int, Year> {
        override fun convert(p0: Int): Year? = Year.of(p0)
    }

}