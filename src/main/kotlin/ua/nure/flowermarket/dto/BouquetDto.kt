package ua.nure.flowermarket.dto

import java.util.*

data class BouquetDto(
    val id: UUID?,
    val price: Double,
    val orderId: UUID?,
    val packaging: PackagingDto,
    val flowers: MutableList<PurchaseFlowerDto>
)
