package com.folksdev.account.model



import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Account(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer?,

   /* @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    val transaction:Set<Transaction>?*/

    ){



}
