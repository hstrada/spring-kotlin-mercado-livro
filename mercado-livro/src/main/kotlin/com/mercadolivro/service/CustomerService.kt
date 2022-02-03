package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (var customerRepository: CustomerRepository) {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let { return customers.filter { it.name.contains(name, true) } }
        return customers
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun get(id: Int): CustomerModel {
        return customers.first { it.id == id }
    }

    fun update(customer: CustomerModel) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: Int) {
        customers.removeIf { it.id == id }
    }
}