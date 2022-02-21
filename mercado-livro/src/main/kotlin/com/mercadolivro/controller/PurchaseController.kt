package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostPurchaseRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("/purchases")
class PurchaseController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody purchase: PostPurchaseRequest) {

    }
}