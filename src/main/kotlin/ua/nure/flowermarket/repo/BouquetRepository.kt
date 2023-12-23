package ua.nure.flowermarket.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.nure.flowermarket.entity.BouquetEntity
import java.util.UUID

@Repository
interface BouquetRepository : JpaRepository<BouquetEntity, UUID> {}