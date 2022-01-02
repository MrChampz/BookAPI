package com.felpsmac.bookapi.repositories

import com.felpsmac.bookapi.entity.Book
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface BookRepository: CrudRepository<Book, UUID> {

//    @Executable
//    fun findByBookIdentifier(identifier: String): Book
}