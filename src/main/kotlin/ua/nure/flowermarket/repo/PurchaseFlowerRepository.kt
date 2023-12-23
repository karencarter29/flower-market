package ua.nure.flowermarket.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.nure.flowermarket.entity.PurchaseFlowerEntity
import java.util.UUID

interface PurchaseFlowerRepository : JpaRepository<PurchaseFlowerEntity, UUID> {
}