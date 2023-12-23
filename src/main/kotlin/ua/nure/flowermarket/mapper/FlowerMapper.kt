package ua.nure.flowermarket.mapper

import ua.nure.flowermarket.dto.FlowerDto
import ua.nure.flowermarket.entity.FlowerEntity

fun FlowerEntity.toDto(): FlowerDto = FlowerDto(
        id = this.id,
        name = this.name,
        price = this.price
)

fun FlowerDto.toEntity(): FlowerEntity = FlowerEntity(
        id = this.id,
        name = this.name,
        price = this.price
)