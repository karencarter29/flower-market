package ua.nure.flowermarket.entity

import jakarta.persistence.*
import org.springframework.boot.fromApplication
import java.util.*

@Entity
@Table(name = "bouquets")
data class BouquetEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val price: Double,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = true)
    var order: OrderEntity? = null,
    @OneToOne
    @JoinColumn(name = "packaging_id", nullable = false)
    val packaging: PackagingEntity,
    @OneToMany(cascade = [ CascadeType.ALL ])
    @JoinTable(
        name = "purchase_flowers",
        joinColumns = [ JoinColumn(name = "bouquet_id") ],
        inverseJoinColumns = [ JoinColumn(name = "id") ]
    )
    val flowers: MutableList<PurchaseFlowerEntity> = mutableListOf(),
)
