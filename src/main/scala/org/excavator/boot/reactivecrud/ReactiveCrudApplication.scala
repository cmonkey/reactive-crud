package org.excavator.boot.reactivecrud.entity

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ReactiveCrudApplication {

}

object ReactiveCrudApplication{
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ReactiveCrudApplication], args:_*)
  }
}
