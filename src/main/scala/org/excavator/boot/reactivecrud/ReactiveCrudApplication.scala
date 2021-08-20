package org.excavator.boot.reactivecrud

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.{CompositeDatabasePopulator, ConnectionFactoryInitializer, ResourceDatabasePopulator}

@SpringBootApplication
class ReactiveCrudApplication {

  @Bean
  def databaseInitalize(connectionFactory:ConnectionFactory) = {
    val initializer = new ConnectionFactoryInitializer
    initializer.setConnectionFactory(connectionFactory)

    val populator = new CompositeDatabasePopulator()
    populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema/schema.sql")))

    initializer.setDatabasePopulator(populator)

    initializer
  }

}

object ReactiveCrudApplication{
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ReactiveCrudApplication], args:_*)
  }
}
