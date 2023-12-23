package ua.nure.flowermarket.dto

import java.util.*

data class PurchaseFlowerDto(
    val id: UUID? = null,
    val bouquetId: UUID,
    val flower: FlowerDto,
    val number: Long
)
