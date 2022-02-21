package com.mercadolivro.controller.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequest(
    @field:NotNull
    @field:Positive
    val customerId: Int,

    val bookIds: Set<Int>
)
