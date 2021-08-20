package org.excavator.boot.reactivecrud.controller

object CatalogueControllerAPIPaths {
  val CREATE = "/"
  val GET_ITEMS = "/"
  val GET_ITEMS_STREAM = "/stream"

  val GET_ITEM = "/{sku}"
  val UPDATE = "/{sku}"
  val UPLOAD_IMAGE = "/{sku}/image"
  val GET_ITEMS_WS_EVENTS = BASE_PATH + "/ws/events"
  val BASE_PATH = "/api/v1"
}
