package ua.nure.flowermarket.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "packaging")
data class PackagingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val name: String,
    val price: Double
)
