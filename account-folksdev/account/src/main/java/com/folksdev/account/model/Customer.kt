package com.folksdev.account.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

data class Customer(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val name:String?,
    val lastName:String?,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val accounts:Set<Account>?
)
