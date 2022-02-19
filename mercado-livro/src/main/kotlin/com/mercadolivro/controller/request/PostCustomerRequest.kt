package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Name is mandatory.")
    var name: String,
    @field:Email(message = "Email is mandatory.")
    var email: String
)