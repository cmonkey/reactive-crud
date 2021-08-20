package org.excavator.boot.reactivecrud

import scala.beans.BeanProperty

class CataLogueItem {

  @BeanProperty
  var id:Long = _

  @BeanProperty
  var sku:String = _

  @BeanProperty
  var name:String = _

}
