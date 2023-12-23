package ua.nure.flowermarket.mapper

import org.springframework.stereotype.Component
import ua.nure.flowermarket.dto.BouquetDto
import ua.nure.flowermarket.entity.BouquetEntity

@Component
class BouquetMapper(
    private val purchaseFlowerMapper: PurchaseFlowerMapper
) {
    fun toDto(bouquetEntity: BouquetEntity): BouquetDto = BouquetDto(
        id = bouquetEntity.id,
        packaging = bouquetEntity.packaging.toDto(),
        price = bouquetEntity.price,
        orderId = bouquetEntity.order?.id,
        flowers = bouquetEntity.flowers.map { purchaseFlowerMapper.toDto(it) }.toMutableList()
    )

    fun toEntity(bouquetDto: BouquetDto): BouquetEntity = BouquetEntity(
        id = bouquetDto.id,
        packaging = bouquetDto.packaging.toEntity(),
        price = bouquetDto.price,
        flowers = bouquetDto.flowers.map { purchaseFlowerMapper.toEntity(it) }.toMutableList()
    )
}