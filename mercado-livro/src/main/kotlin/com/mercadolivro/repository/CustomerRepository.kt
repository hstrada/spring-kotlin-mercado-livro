package com.mercadolivro.repository

import com.mercadolivro.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository <Customer, Int> {
    fun findByNameContaining(name: String): List<Customer>
    abstract fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): Customer?
}