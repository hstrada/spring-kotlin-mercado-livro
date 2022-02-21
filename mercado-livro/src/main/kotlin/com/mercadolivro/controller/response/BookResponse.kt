package com.mercadolivro.controller.response

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.Customer
import java.math.BigDecimal

data class BookResponse(

    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: Customer? = null,

    var status: BookStatus? = null
)
