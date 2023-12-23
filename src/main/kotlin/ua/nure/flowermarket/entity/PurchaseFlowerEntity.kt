package ua.nure.flowermarket.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "purchase_flowers")
data class PurchaseFlowerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @ManyToOne
    @JoinColumn(name = "bouquet_id", referencedColumnName = "id")
    val bouquet: BouquetEntity,
    @OneToOne
    @JoinColumn(name = "flower_id", nullable = false)
    val flower: FlowerEntity,
    val number: Long
)
