package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "{name.notempty}")
    var name: String,
    @field:Email(message = "Email is mandatory.")
    @EmailAvailable
    var email: String
)