package ua.nure.flowermarket.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val date: Date,
    val notes: String? = null,
    val totalPrice: Double,
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val bouquets: MutableList<BouquetEntity> = mutableListOf()
)
