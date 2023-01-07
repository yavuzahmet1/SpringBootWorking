package com.folksdev.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val id: String,
    val balance: BigDecimal? = BigDecimal.ZERO,
    val transactions: Set<TransactionDto>?,
    val creationDate: LocalDateTime
) {

}
