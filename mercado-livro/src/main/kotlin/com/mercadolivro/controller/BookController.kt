package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.model.BookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll();
    }

    @GetMapping("/actives")
    fun findActives(): List<BookModel> = bookService.findActives();

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel = bookService.findById(id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Int) { bookService.deleteById(id) }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateById(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}