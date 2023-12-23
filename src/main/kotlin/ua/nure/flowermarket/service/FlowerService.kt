package ua.nure.flowermarket.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ua.nure.flowermarket.dto.CreateFlowerDto
import ua.nure.flowermarket.dto.FlowerDto
import ua.nure.flowermarket.entity.FlowerEntity
import ua.nure.flowermarket.meta.ErrorMessages
import ua.nure.flowermarket.exceptions.NotFoundException
import ua.nure.flowermarket.mapper.toDto
import ua.nure.flowermarket.repo.FlowerRepository
import java.util.UUID

@Service
class FlowerService(
    private val flowerRepository: FlowerRepository
) {
    fun get(id: UUID): FlowerDto {
        return flowerRepository.findByIdOrNull(id)?.toDto()
            ?: throw NotFoundException(ErrorMessages.FLOWER_NOT_FOUND)
    }

    fun getAll(): List<FlowerDto> {
        return flowerRepository.findAll().map { it.toDto() }
    }

    fun create(flowerDto: CreateFlowerDto) {
        val flowerEntity = FlowerEntity(
            name = flowerDto.name,
            price = flowerDto.price
        )
        flowerRepository.save(flowerEntity)
    }

    fun delete(id: UUID) {
        flowerRepository.deleteById(id)
    }
}