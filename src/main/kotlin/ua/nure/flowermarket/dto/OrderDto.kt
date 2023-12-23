package ua.nure.flowermarket.dto

import java.util.*

data class OrderDto(
    val id: UUID? = null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val date: Date,
    val notes: String?,
    val totalPrice: Double,
    val bouquets: MutableList<BouquetDto>
)
