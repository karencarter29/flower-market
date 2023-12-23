package ua.nure.flowermarket.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.nure.flowermarket.dto.CreateOrderDto
import ua.nure.flowermarket.dto.OrderDto
import ua.nure.flowermarket.service.OrderService
import java.util.UUID

@RestController
@RequestMapping("orders")
class OrderController(
        private val orderService: OrderService
) {
    @GetMapping
    fun getAll(): List<OrderDto> {
        return orderService.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): OrderDto {
        return orderService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody createOrderDto: CreateOrderDto) {
        orderService.create(createOrderDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) {
        orderService.delete(id)
    }
}