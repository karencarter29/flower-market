package ua.nure.flowermarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlowerMarketApplication

fun main(args: Array<String>) {
	runApplication<FlowerMarketApplication>(*args)
}
