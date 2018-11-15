package de.bindoc.mongoyeartest

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Year

@SpringBootTest
@RunWith(SpringRunner::class)
class FoobarRepositoryTest {

    @Autowired
    lateinit var foobarRepository: FoobarRepository

    @Test
    fun save() {
        foobarRepository.save(Foobar(year = Year.of(2017), name = "Halo"))
    }
}