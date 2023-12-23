package ua.nure.flowermarket.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.nure.flowermarket.entity.OrderEntity
import java.util.UUID

@Repository
interface OrderRepository : JpaRepository<OrderEntity, UUID> {}