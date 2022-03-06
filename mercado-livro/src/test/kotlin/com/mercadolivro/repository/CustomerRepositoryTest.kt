package com.mercadolivro.repository

import com.mercadolivro.helper.buildCustomer
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerRepositoryTest {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @Test
    fun `should return name containing`() {
        val customer1 = customerRepository.save(buildCustomer(name = "customer1"))
        val customer2 = customerRepository.save(buildCustomer(name = "customer2"))
        val customer3 = customerRepository.save(buildCustomer(name = "cliente3"))

        val customers = customerRepository.findByNameContaining("custo")

        assertEquals(listOf(customer1, customer2), customers)
    }

    @Nested
    inner class `exists by email` {
        @Test
        fun `should return true when email exists`() {
            val email = "email@teste.com"
            customerRepository.save(buildCustomer(email = email))
            val exists = customerRepository.existsByEmail(email)
            assertTrue(exists)
        }

        @Test
        fun `should return false when email does not exists`() {
            val email = "nonexist@teste.com"
            val exists = customerRepository.existsByEmail(email)
            assertFalse(exists)
        }
    }
}