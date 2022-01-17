package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {
    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerModel> {
        name?.let { return customers.filter { it.name.contains(name, true) } }
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        val id = if (customers.isEmpty()) 1 else { customers.last().id.toInt() + 1 }.toString()

        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.first { it -> it.id == id }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customers.first { it -> it.id == id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String) {
        customers.removeIf { it.id == id }
    }
}