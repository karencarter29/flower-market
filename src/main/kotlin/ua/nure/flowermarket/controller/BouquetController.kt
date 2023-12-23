package ua.nure.flowermarket.controller

import org.springframework.web.bind.annotation.*
import ua.nure.flowermarket.dto.BouquetDto
import ua.nure.flowermarket.dto.CreateBouquetDto
import ua.nure.flowermarket.service.BouquetService
import java.util.UUID

@RestController
@RequestMapping("bouquets")
class BouquetController(
        private val bouquetService: BouquetService
) {
    @GetMapping
    fun getAll(): List<BouquetDto> {
        return bouquetService.getAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): BouquetDto {
        return bouquetService.get(id)
    }

    @PostMapping
    fun create(@RequestBody createBouquetDto: CreateBouquetDto) {
        return bouquetService.createBouquet(createBouquetDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) {
        bouquetService.delete(id)
    }
}