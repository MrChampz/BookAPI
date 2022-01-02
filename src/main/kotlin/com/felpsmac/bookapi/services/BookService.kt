package com.felpsmac.bookapi.services

import com.felpsmac.bookapi.entity.Book
import com.felpsmac.bookapi.repositories.BookRepository
import jakarta.inject.Singleton
import java.util.*

@Singleton
class BookService(private val repository: BookRepository) {

    fun getAllBooks() = repository.findAll()

//    fun getBookByIdentifier(identifier: String) = repository.findByBookIdentifier(identifier)

    fun saveOrUpdateBook(book: Book): Book {
        var saved: Book? = null

        saved = if (book.id != null && repository.existsById(book.id)) {
            repository.update(book)
        } else {
            repository.save(book)
        }

        return saved
    }

    fun deleteBook(id: UUID) = repository.deleteById(id)
}