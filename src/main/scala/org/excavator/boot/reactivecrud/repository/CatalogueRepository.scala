package org.excavator.boot.reactivecrud.repository

import org.excavator.boot.reactivecrud.entity.CataLogueItem
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import reactor.core.publisher.Mono

trait CatalogueRepository extends ReactiveSortingRepository[CataLogueItem, Long]{

  def findBySku(sku:String): Mono[CataLogueItem]

}
