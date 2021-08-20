package org.excavator.boot.reactivecrud.service

import org.excavator.boot.reactivecrud.entity.CataLogueItem
import org.excavator.boot.reactivecrud.repository.CatalogueRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

import java.time.Instant
import javax.annotation.Resource

@Service
class CataLogueCrudService(@Resource catalogueRepository: CatalogueRepository) {
  def findAll() = {
    catalogueRepository.findAll()
  }

  def create(cataLogueItem: CataLogueItem) = {
    catalogueRepository.save(cataLogueItem).subscribe()
  }

  def findById(id:Long) = {
    catalogueRepository.findById(id)
  }

  def findBySku(sku:String) = {
    catalogueRepository.findBySku(sku)
  }

  def update(cataLogueItem: CataLogueItem) = {
    catalogueRepository.save(cataLogueItem)
  }

  def delete(id:Long) = {
    catalogueRepository.deleteById(id)
  }


  def publishCatalogueItemEvent(): Unit = {

  }

  def addCatalogItem(cataLogueItem: CataLogueItem) = {
    cataLogueItem.setCreatedOn(Instant.now())
    catalogueRepository.save(cataLogueItem)
      .doOnSuccess(item => publishCatalogueItemEvent())
      .flatMap(item => Mono.just(item.getId))
  }

}
