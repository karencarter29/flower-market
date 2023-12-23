package ua.nure.flowermarket.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.nure.flowermarket.entity.FlowerEntity
import java.util.UUID

@Repository
interface FlowerRepository : JpaRepository<FlowerEntity, UUID> {}