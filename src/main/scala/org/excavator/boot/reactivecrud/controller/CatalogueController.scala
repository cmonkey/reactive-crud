package org.excavator.boot.reactivecrud.controller

import org.excavator.boot.reactivecrud.entity.CataLogueItem
import org.excavator.boot.reactivecrud.service.CataLogueCrudService
import org.slf4j.LoggerFactory
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RequestMapping, ResponseStatus, RestController}
import reactor.core.publisher.Mono

import javax.annotation.Resource
import javax.validation.Valid

@RestController
@RequestMapping(Array("/api/v1"))
class CatalogueController {

  val log = LoggerFactory.getLogger(classOf[CatalogueController])

  @Resource
  val catalogueCrudService: CataLogueCrudService = null

  @PostMapping(Array("/", "/create"))
  @ResponseStatus(value = HttpStatus.CREATED)
  def addCatalogueItem(@Valid @RequestBody cataLogueItem: CataLogueItem) = {
    val id = catalogueCrudService.addCatalogItem(cataLogueItem)
    id.map(value => ResponseEntity.status(HttpStatus.CREATED).body(value)).cast(classOf[ResponseEntity[Long]])
  }

  @GetMapping(Array("/{id}"))
  def findById(@PathVariable("id") id:Long) = {
    val e = catalogueCrudService.findById(id)
    val status = if(e != null) HttpStatus.OK else HttpStatus.NOT_FOUND

    new ResponseEntity[Mono[CataLogueItem]](e, status)
  }

  @GetMapping(Array("/sku/{sku}"))
  def findByName(@PathVariable("sku") sku:String) = {
    catalogueCrudService.findBySku(sku)
  }

  @PutMapping(Array("/update"))
  @ResponseStatus(HttpStatus.OK)
  def update(@RequestBody cataLogueItem: CataLogueItem) = {
    catalogueCrudService.update(cataLogueItem)
  }

  @DeleteMapping(Array("/delete/{id}"))
  @ResponseStatus(HttpStatus.OK)
  def delete(@PathVariable("id") id:Long) = {
    catalogueCrudService.delete(id)
  }

  @GetMapping(Array("/"))
  @ResponseStatus(value = HttpStatus.OK)
  def querySku() = {
    val r = catalogueCrudService.findAll()
    r
  }

}
