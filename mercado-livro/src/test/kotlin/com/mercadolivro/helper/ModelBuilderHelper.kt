package com.mercadolivro.helper

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Role
import com.mercadolivro.model.Book
import com.mercadolivro.model.Customer
import com.mercadolivro.model.Purchase
import java.math.BigDecimal
import java.util.*

fun buildCustomer(
    id: Int? = null,
    name: String = "Customer Name",
    email: String = "${UUID.randomUUID()}@email.com",
    password: String = "password"
) = Customer(
    id = id,
    name = name,
    email = email,
    status = CustomerStatus.ATIVO,
    password = password,
    roles = setOf(Role.CUSTOMER)
)

fun buildPurchaseModel(
    id: Int? = null,
    customer: Customer = buildCustomer(),
    books: MutableList<Book> = mutableListOf(),
    nfe: String? = UUID.randomUUID().toString(),
    price: BigDecimal = BigDecimal.TEN
) = Purchase(
    id = id,
    customer = customer,
    books = books,
    nfe = nfe,
    price = price
)