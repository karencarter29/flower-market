package ua.nure.flowermarket.dto

import java.util.UUID

data class CreateBouquetDto(
    val flowerMapDto: List<FlowerMapDto>,
    val packagingId: UUID
)
