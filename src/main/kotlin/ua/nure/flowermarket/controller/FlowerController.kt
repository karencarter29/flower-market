package ua.nure.flowermarket.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ua.nure.flowermarket.dto.CreateFlowerDto
import ua.nure.flowermarket.dto.FlowerDto
import ua.nure.flowermarket.service.FlowerService
import java.util.UUID

@RestController
@RequestMapping("flowers")
class FlowerController(
        private val flowerService: FlowerService
) {
    @GetMapping
    fun getAll(): List<FlowerDto> {
        return flowerService.getAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): FlowerDto {
        return flowerService.get(id)
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun create(@RequestBody createFlowerDto: CreateFlowerDto) {
        flowerService.create(createFlowerDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) {
        flowerService.delete(id)
    }
}