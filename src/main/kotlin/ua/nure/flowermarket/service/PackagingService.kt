package ua.nure.flowermarket.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ua.nure.flowermarket.dto.CreatePackagingDto
import ua.nure.flowermarket.dto.PackagingDto
import ua.nure.flowermarket.entity.PackagingEntity
import ua.nure.flowermarket.exceptions.NotFoundException
import ua.nure.flowermarket.mapper.toDto
import ua.nure.flowermarket.meta.ErrorMessages
import ua.nure.flowermarket.repo.PackagingRepository
import java.util.UUID

@Service
class PackagingService(
    private val packagingRepository: PackagingRepository
) {
    fun getAll(): List<PackagingDto> {
        return packagingRepository.findAll().map { it.toDto() }
    }

    fun get(id: UUID): PackagingDto {
        return packagingRepository.findByIdOrNull(id)?.toDto() ?: throw NotFoundException(ErrorMessages.PACKAGING_NOT_FOUND)
    }

    fun create(packagingDto: CreatePackagingDto) {
        val packagingEntity = PackagingEntity(
            name = packagingDto.name,
            price = packagingDto.price
        )
        packagingRepository.save(packagingEntity)
    }

    fun delete(id: UUID) {
        packagingRepository.deleteById(id)
    }
}