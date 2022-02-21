package com.mercadolivro.repository

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.Book
import com.mercadolivro.model.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {
    fun findByStatus(ativo: BookStatus, pageable: Pageable): Page<Book>
    fun findByCustomer(customer: Customer): List<Book>

    // fun findAll(pageable: Pageable): Page<BookModel>
}