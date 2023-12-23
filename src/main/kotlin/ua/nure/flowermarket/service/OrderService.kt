package ua.nure.flowermarket.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ua.nure.flowermarket.dto.CreateOrderDto
import ua.nure.flowermarket.dto.OrderDto
import ua.nure.flowermarket.entity.OrderEntity
import ua.nure.flowermarket.exceptions.NotFoundException
import ua.nure.flowermarket.mapper.OrderMapper
import ua.nure.flowermarket.meta.ErrorMessages
import ua.nure.flowermarket.repo.BouquetRepository
import ua.nure.flowermarket.repo.OrderRepository
import java.util.*

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderMapper: OrderMapper,
    private val bouquetRepository: BouquetRepository
) {
    fun getAll(): List<OrderDto> {
        return orderRepository.findAll().map { orderMapper.toDto(it) }
    }

    fun getById(id: UUID): OrderDto {
        return orderMapper.toDto(
            orderRepository.findByIdOrNull(id) ?: throw NotFoundException(ErrorMessages.ORDER_NOT_FOUND))
    }

    fun create(createOrderDto: CreateOrderDto) {
        val bouquets = createOrderDto.bouquets.map { bouquetRepository.getReferenceById(it) }
        var totalPrice = 0.0
        bouquets.forEach{ totalPrice += it.price }
        val order = OrderEntity(
            firstName = createOrderDto.firstName,
            lastName = createOrderDto.lastName,
            phoneNumber = createOrderDto.phoneNumber,
            address = createOrderDto.address,
            notes = createOrderDto.notes,
            date = createOrderDto.date,
            totalPrice = totalPrice
        )
        orderRepository.save(order)
        bouquets.forEach { it.order = order }
        bouquetRepository.saveAll(bouquets)
    }

    fun delete(id: UUID) {
        orderRepository.deleteById(id)
    }
}