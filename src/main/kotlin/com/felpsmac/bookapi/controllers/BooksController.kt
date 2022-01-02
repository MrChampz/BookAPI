package com.felpsmac.bookapi.controllers

import com.felpsmac.bookapi.entity.Book
import com.felpsmac.bookapi.services.BookService
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/books")
class BooksController(private val bookService: BookService) {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllBooks(): Iterable<Book> = bookService.getAllBooks()

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun saveOrUpdateBook(@Body book: Book) = bookService.saveOrUpdateBook(book)

    @Put("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun updateBook(id: UUID, @Body book: Book): Book {
        val bookWithId = book.copy(id = id)
        return bookService.saveOrUpdateBook(bookWithId)
    }

    @Delete("/{id}")
    fun deleteBookById(id: UUID): HttpStatus {
        bookService.deleteBook(id)
        return HttpStatus.OK
    }
}