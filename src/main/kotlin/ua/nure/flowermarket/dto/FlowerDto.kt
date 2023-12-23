package ua.nure.flowermarket.dto

import java.util.UUID

data class FlowerDto(
    val id: UUID?,
    val name: String,
    val price: Double
)
