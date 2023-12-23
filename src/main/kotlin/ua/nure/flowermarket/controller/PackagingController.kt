package ua.nure.flowermarket.controller

import org.springframework.web.bind.annotation.*
import ua.nure.flowermarket.dto.CreatePackagingDto
import ua.nure.flowermarket.dto.PackagingDto
import ua.nure.flowermarket.service.PackagingService
import java.util.UUID

@RestController
@RequestMapping("packaging")
class PackagingController(
    private val packagingService: PackagingService
) {
    @GetMapping
    fun getAll(): List<PackagingDto> {
        return packagingService.getAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): PackagingDto {
        return packagingService.get(id)
    }

    @PostMapping
    fun create(@RequestBody createPackagingDto: CreatePackagingDto) {
        packagingService.create(createPackagingDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) {
        packagingService.delete(id)
    }
}