package ua.nure.flowermarket.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ua.nure.flowermarket.dto.BouquetDto
import ua.nure.flowermarket.dto.CreateBouquetDto
import ua.nure.flowermarket.entity.BouquetEntity
import ua.nure.flowermarket.entity.PurchaseFlowerEntity
import ua.nure.flowermarket.meta.ErrorMessages
import ua.nure.flowermarket.exceptions.NotFoundException
import ua.nure.flowermarket.mapper.BouquetMapper
import ua.nure.flowermarket.repo.*
import java.util.*

@Service
class BouquetService(
    private val bouquetRepository: BouquetRepository,
    private val flowerRepository: FlowerRepository,
    private val packagingRepository: PackagingRepository,
    private val orderRepository: OrderRepository,
    private val purchaseFlowerRepository: PurchaseFlowerRepository,
    private val bouquetMapper: BouquetMapper
) {
    fun getAll(): List<BouquetDto> {
        return bouquetRepository.findAll().map { bouquetMapper.toDto(it) }
    }

    fun get(id: UUID): BouquetDto {
        return bouquetMapper.toDto(
            bouquetRepository.findByIdOrNull(id) ?: throw NotFoundException(ErrorMessages.BOUQUET_NOT_FOUND))
    }

    fun getByOrder(orderId: UUID): List<BouquetDto> {
        val orderEntity = orderRepository.findByIdOrNull(orderId) ?: throw NotFoundException(ErrorMessages.ORDER_NOT_FOUND)
        return orderEntity.bouquets.map { bouquetMapper.toDto(it) }
    }

    fun createBouquet(bouquetDto: CreateBouquetDto) {
        var price = 0.0
        val packaging = packagingRepository.findByIdOrNull(bouquetDto.packagingId) ?: throw NotFoundException(ErrorMessages.PACKAGING_NOT_FOUND)
        price += packaging.price
        val flowerMap = bouquetDto.flowerMapDto
        flowerMap.forEach {
            val flower = flowerRepository.findByIdOrNull(it.flowerId) ?: throw NotFoundException(ErrorMessages.FLOWER_NOT_FOUND)
            price += flower.price * it.number
        }
        val bouquet = BouquetEntity(
            price = price,
            packaging = packaging
        )
        bouquetRepository.save(bouquet)
        flowerMap.forEach {
            val flower = flowerRepository.findByIdOrNull(it.flowerId) ?: throw NotFoundException(ErrorMessages.FLOWER_NOT_FOUND)
            val purchaseFlowerEntity = PurchaseFlowerEntity(
                bouquet = bouquet,
                flower = flower,
                number = it.number
            )
            purchaseFlowerRepository.save(purchaseFlowerEntity)
        }
    }

    fun delete(id: UUID) {
        bouquetRepository.deleteById(id)
    }
}