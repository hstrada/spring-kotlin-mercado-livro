package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Profile
import javax.persistence.*

@Entity(name = "customers")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus?,

    @Column
    var password: String,

    @Column(name = "role")
    @CollectionTable(
        name = "customers_roles",
        joinColumns = [
            JoinColumn(name = "customer_id")
        ]
    )
    @ElementCollection(targetClass = Profile::class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    var roles: Set<Profile> = setOf()
)