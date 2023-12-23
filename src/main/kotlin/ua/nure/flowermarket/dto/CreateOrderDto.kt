package ua.nure.flowermarket.dto

import java.util.*

data class CreateOrderDto(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val date: Date,
    val notes: String?,
    val bouquets: List<UUID>
)
