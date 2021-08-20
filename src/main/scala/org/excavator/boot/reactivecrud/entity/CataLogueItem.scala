package org.excavator.boot.reactivecrud.entity

import org.springframework.data.relational.core.mapping.{Column, Table}

import java.time.Instant
import javax.validation.constraints.{NotEmpty, NotNull}
import scala.beans.BeanProperty

@Table("catalogue_items")
class CataLogueItem {

  @BeanProperty
  @Column("ID")
  var id:Long = _

  @BeanProperty
  @NotEmpty(message = "sku cannot be null or empty")
  @Column("SKU_NUMBER")
  var sku:String = _

  @BeanProperty
  @NotEmpty(message = "name cannot be null or empty")
  @Column("ITEM_NAME")
  var name:String = _

  @BeanProperty
  @NotNull(message = "Inventory cannot be null or empty")
  @Column("INVENTORY")
  var inventory: Int = _;

  @BeanProperty
  @Column("CREATED_ON")
  var createdOn:Instant = _

  @BeanProperty
  @Column("UPDATED_ON")
  var updatedOn:Instant = _

}
