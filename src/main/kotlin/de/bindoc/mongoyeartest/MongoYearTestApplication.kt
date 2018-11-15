package de.bindoc.mongoyeartest

import org.bson.types.ObjectId
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
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


