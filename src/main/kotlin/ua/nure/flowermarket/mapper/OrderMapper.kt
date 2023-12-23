package ua.nure.flowermarket.mapper

import org.springframework.stereotype.Component
import ua.nure.flowermarket.dto.OrderDto
import ua.nure.flowermarket.entity.OrderEntity

@Component
class OrderMapper(
    private val bouquetMapper: BouquetMapper
) {
    fun toDto(orderEntity: OrderEntity): OrderDto = OrderDto(
        id = orderEntity.id,
        firstName = orderEntity.firstName,
        lastName = orderEntity.lastName,
        phoneNumber = orderEntity.phoneNumber,
        address = orderEntity.address,
        date = orderEntity.date,
        notes = orderEntity.notes,
        totalPrice = orderEntity.totalPrice,
        bouquets = orderEntity.bouquets.map { bouquetMapper.toDto(it) }.toMutableList()
    )

    fun toEntity(orderDto: OrderDto): OrderEntity = OrderEntity(
        id = orderDto.id,
        firstName = orderDto.firstName,
        lastName = orderDto.lastName,
        phoneNumber = orderDto.phoneNumber,
        address = orderDto.address,
        date = orderDto.date,
        notes = orderDto.notes,
        totalPrice = orderDto.totalPrice,
        bouquets = orderDto.bouquets.map { bouquetMapper.toEntity(it) }.toMutableList()
    )
}