package ua.nure.flowermarket.mapper

import ua.nure.flowermarket.dto.PackagingDto
import ua.nure.flowermarket.entity.PackagingEntity

fun PackagingEntity.toDto(): PackagingDto = PackagingDto(
    id = this.id,
    name = this.name,
    price = this.price
)

fun PackagingDto.toEntity(): PackagingEntity = PackagingEntity(
    id = this.id,
    name = this.name,
    price = this.price
)