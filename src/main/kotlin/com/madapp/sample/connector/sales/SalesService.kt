package com.madapp.sample.connector.sales

import com.madapp.sample.connector.product.connector.builder.buildProductConnector
import kotlinx.coroutines.runBlocking

class SalesService {

    private val productId = "0123"
    private val productService = buildProductConnector()

    fun start() {
        println("Sales: Service has started")
        println("Sales: Product with id: $productId requested")
        val product = runBlocking { productService.getProduct(productId) }
        println("Sales: Received a product object: $product")
    }
}