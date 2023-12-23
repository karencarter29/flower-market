package ua.nure.flowermarket.mapper

import org.springframework.stereotype.Component
import ua.nure.flowermarket.dto.PurchaseFlowerDto
import ua.nure.flowermarket.entity.PurchaseFlowerEntity
import ua.nure.flowermarket.repo.BouquetRepository

@Component
class PurchaseFlowerMapper(
    private val bouquetRepository: BouquetRepository
) {
    fun toDto(purchaseFlowerEntity: PurchaseFlowerEntity) = PurchaseFlowerDto(
        id = purchaseFlowerEntity.id,
        bouquetId = purchaseFlowerEntity.bouquet.id!!,
        flower = purchaseFlowerEntity.flower.toDto(),
        number = purchaseFlowerEntity.number
    )

    fun toEntity(purchaseFlowerDto: PurchaseFlowerDto) = PurchaseFlowerEntity(
        id = purchaseFlowerDto.id,
        bouquet = bouquetRepository.getReferenceById(purchaseFlowerDto.bouquetId),
        flower = purchaseFlowerDto.flower.toEntity(),
        number = purchaseFlowerDto.number
    )
}